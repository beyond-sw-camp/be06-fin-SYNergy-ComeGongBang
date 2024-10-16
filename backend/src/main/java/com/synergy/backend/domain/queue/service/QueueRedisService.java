package com.synergy.backend.domain.queue.service;

import com.synergy.backend.domain.queue.model.response.QueueStatus;
import com.synergy.backend.domain.queue.model.response.RegisterQueueResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Service
@RequiredArgsConstructor
public class QueueRedisService {

    private final RedisTemplate<String, String> redisTemplate;

    private static final String ACTIVE_KEY_PREFIX = "active:%s";
    private static final String WAITING_KEY_PREFIX = "waiting:%s";
    private static final String USER_QUEUE_WAIT_KEY = "queue:%s:member:%s";


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


    public Boolean isEmpty(Long couponIdx) {
        Long size = redisTemplate.opsForZSet().size(WAITING_KEY_PREFIX.formatted(couponIdx));
        return size == null || size == 0;
    }


    public void remove(Long couponIdx, Long memberIdx) {
        redisTemplate.opsForZSet().remove(WAITING_KEY_PREFIX.formatted(couponIdx), String.valueOf(memberIdx));
    }


    public Double getProgress(Long size, Long rank) {
        if (size <= 0) {
            return 0.0;
        }
        return 100 - (double) rank / size * 100;
    }


    public Long moveActiveQueue(String queueIdx, Long count) {
        Set<String> range = redisTemplate.opsForZSet().range(queueIdx, 0, count - 1);

        if (range == null || range.isEmpty()) return 0L;

        for (String memberIdx : range) {
            redisTemplate.opsForSet().add(ACTIVE_KEY_PREFIX.formatted(queueIdx.split(":")[1]), memberIdx);
        }
        redisTemplate.opsForZSet().remove(queueIdx, range.toArray());
        return (long) range.size();
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


    public List<String> getWaitingUsers(String queueIdx, Long maxToMove) {
        Set<String> range = redisTemplate.opsForZSet().range(queueIdx, 0, maxToMove - 1);
        if (range != null) {
            return new ArrayList<>(range);
        }
        return new ArrayList<>();
    }

    public void registActiveQueue(Long memberIdx, Long couponIdx) {
        redisTemplate.opsForSet().add(ACTIVE_KEY_PREFIX.formatted(couponIdx), String.valueOf(memberIdx));
    }

    public void deleteQueue(String queueIdx, Long memberIdx) {
        redisTemplate.opsForZSet().remove(queueIdx, String.valueOf(memberIdx));
    }

    public QueueStatus checkActiveQueue(Long couponIdx, Long memberIdx) {
        Boolean member = redisTemplate.opsForSet().isMember(ACTIVE_KEY_PREFIX.formatted(couponIdx), String.valueOf(memberIdx));

        if (!member) {
            return null;
        }
        return QueueStatus
                .builder()
                .isIssued(true)
                .build();
    }
}
