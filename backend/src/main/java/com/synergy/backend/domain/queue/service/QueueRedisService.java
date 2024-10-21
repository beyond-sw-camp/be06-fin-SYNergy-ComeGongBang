package com.synergy.backend.domain.queue.service;

import com.synergy.backend.domain.coupon.service.CouponService;
import com.synergy.backend.domain.queue.model.response.QueueStatus;
import com.synergy.backend.domain.queue.model.response.RegisterQueueResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class QueueRedisService {

    private final RedisTemplate<String, String> redisTemplate;

    private static final String WAITING_KEY_PREFIX = "waiting:%s";
    private static final String ACTIVE_KEY_PREFIX = "active:%s";
    private static final String FINISH_KEY_PREFIX = "finish:%s";

    @Value("${queue.max-size-active}")
    private int MAX_SIZE_ACTIVE;

    private final CouponService couponService;

    public void save(Long couponIdx, Long memberIdx) throws BaseException {
        double score = (double) LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);

        Boolean result = redisTemplate.opsForZSet().addIfAbsent(
                WAITING_KEY_PREFIX.formatted(couponIdx),
                String.valueOf(memberIdx),
                score);

        if (Boolean.FALSE.equals(result)) {
            throw new BaseException(BaseResponseStatus.ALREADY_REGISTER_QUEUE);
        }
    }


    public QueueStatus getMyPosition(String queueIdx, Long memberIdx) throws BaseException {

        Long rank = redisTemplate.opsForZSet().rank(queueIdx, String.valueOf(memberIdx));
        Long size = redisTemplate.opsForZSet().size(queueIdx);

        if (rank == null || size == null) {
            return null;
        }
        return QueueStatus.builder()
                .position(rank + 1)
                .backPosition(size - rank - 1)
                .queueIdx(queueIdx)
                .progress(getProgress(size, rank))
                .isIssued(false)
                .build();
    }

    public RegisterQueueResponse getMyQueue(Long couponIdx) {
        return RegisterQueueResponse.builder()
                .queueIdx(WAITING_KEY_PREFIX.formatted(couponIdx))
                .inQueue(true)
                .build();
    }

    public Double getProgress(Long size, Long rank) {
        if (size <= 0) {
            return 0.0;
        }
        return 100 - (double) rank / size * 100;
    }


    public Boolean isEmpty(Long couponIdx) {
        Long size = redisTemplate.opsForZSet().size(WAITING_KEY_PREFIX.formatted(couponIdx));
        return size == null || size == 0;
    }

    public void registFinishQueue(Long memberIdx, Long couponIdx) {
        redisTemplate.opsForSet().add(FINISH_KEY_PREFIX.formatted(couponIdx), String.valueOf(memberIdx));
    }

    public void registActiveQueue(Long memberIdx, Long couponIdx) {
        double score = (double) LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        redisTemplate.opsForZSet().add(ACTIVE_KEY_PREFIX.formatted(couponIdx), String.valueOf(memberIdx), score);
    }

    public void deleteWaitQueue(String queueIdx, Long memberIdx) {
        redisTemplate.opsForZSet().remove(queueIdx, String.valueOf(memberIdx));
    }

    public void deleteActiveQueue(Long memberIdx, Long couponIdx) {
        redisTemplate.opsForZSet().remove(ACTIVE_KEY_PREFIX.formatted(couponIdx), String.valueOf(memberIdx));
    }

    public void moveActiveQueue(String queueIdx) {
        double score = (double) LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        String couponIdx = queueIdx.split(":")[1];
        String activeQueueKey = ACTIVE_KEY_PREFIX.formatted(couponIdx);
        Long activeCount = redisTemplate.opsForZSet().zCard(activeQueueKey);

        if (activeCount == null) activeCount = 0L;
        int count = (int) (MAX_SIZE_ACTIVE - activeCount);

        Set<String> range = redisTemplate.opsForZSet().range(queueIdx, 0, count - 1);
        if (range != null && !range.isEmpty()) {
            for (String memberIdx : range) {
                redisTemplate.opsForZSet().add(activeQueueKey, memberIdx, score);
                Double memberScore = redisTemplate.opsForZSet().score(queueIdx, memberIdx);
                if (memberScore != null) {
                    redisTemplate.opsForZSet().add(activeQueueKey, memberIdx, memberScore);
                }
            }
            redisTemplate.opsForZSet().remove(queueIdx, range.toArray());
        }

        issueCoupons(activeQueueKey, Long.parseLong(couponIdx));
    }

    // 쿠폰 발급 후 완료 큐로 이동하는 로직
//    @Async
    protected void issueCoupons(String activeQueueKey, Long couponIdx) {
        Set<String> activeUsers = redisTemplate.opsForZSet().range(activeQueueKey, 0, -1);
        if (activeUsers == null || activeUsers.isEmpty()) {
            return;
        }

        for (String memberIdx : activeUsers) {
            try {
                couponService.issueCoupon(Long.parseLong(memberIdx), couponIdx);
                registFinishQueue(Long.parseLong(memberIdx), couponIdx);
                redisTemplate.opsForZSet().remove(activeQueueKey, memberIdx);

                log.info("Issued coupon to user {} and moved to complete queue", memberIdx);
            } catch (Exception e) {
                log.error("Failed to issue coupon for user {}: {}", memberIdx, e.getMessage());
            }
        }
    }

    public Set<String> scanKeys(String pattern) throws BaseException {
        Set<String> keys = new HashSet<>();

        ScanOptions keyScanOptions = ScanOptions.scanOptions()
                .match(pattern)
                .count(10)
                .build();

        try (Cursor<byte[]> cursor = Objects.requireNonNull(redisTemplate.getConnectionFactory())
                .getConnection().scan(keyScanOptions)) {
            while (cursor.hasNext()) {
                keys.add(new String(cursor.next()));
            }
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAIL_LOAD_SCAN_REDIS);
        }

        return keys;
    }

    public QueueStatus checkFinishQueue(Long couponIdx, Long memberIdx) {
        Boolean member = redisTemplate.opsForSet().isMember(
                FINISH_KEY_PREFIX.formatted(couponIdx),
                String.valueOf(memberIdx));

        //완료큐에 있음
        if (Boolean.TRUE.equals(member)) {
            return QueueStatus
                    .builder()
                    .isIssued(true)
                    .build();
        }
        //완료큐에 없고 진행큐에 있음
        Long rank = redisTemplate.opsForZSet().rank(
                ACTIVE_KEY_PREFIX.formatted(couponIdx),
                String.valueOf(memberIdx));
        Boolean isInActiveQueue = (rank != null);
        if (Boolean.TRUE.equals(isInActiveQueue)){
            return QueueStatus
                    .builder()
                    .isIssued(false)
                    .build();
        }

        // 둘 다 없음, 즉 발급 X

        return null;
    }

    /**
     * 활성화 열 인원이 MAX_ACTIVE_QUEUE 보다 작으면서 대기열이 없으면 바로 활성화 열 -> false
     * 그렇지 않으면 대기열 -> true
     */
    public boolean isWaitQueueNecessary(Long couponIdx) {
        Long activeCount = redisTemplate.opsForZSet().zCard(ACTIVE_KEY_PREFIX.formatted(couponIdx));
        Long waitingCount = redisTemplate.opsForZSet().zCard(WAITING_KEY_PREFIX.formatted(couponIdx));
        if (activeCount == null) {
            activeCount = 0L;
        }
        if (waitingCount == null) {
            waitingCount = 0L;
        }

        return waitingCount != 0 || activeCount >= 5;
    }

    public String isSoldOut(Long couponIdx) {
        return redisTemplate.opsForValue().get("soldout:coupon:" + couponIdx);
    }
}
