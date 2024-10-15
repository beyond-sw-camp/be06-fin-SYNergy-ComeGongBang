package com.synergy.backend.domain.queue.service;

import com.synergy.backend.domain.queue.model.response.QueueStatus;
import com.synergy.backend.domain.queue.model.response.RegisterQueueResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.KeyScanOptions;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class QueueRedisServiceImpl implements QueueRedisService {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public void save(Long couponIdx, Long memberIdx) throws BaseException {
        double score = (double) LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        Boolean result = redisTemplate.opsForZSet().addIfAbsent(getKey(couponIdx),
                String.valueOf(memberIdx), score);
        if (Boolean.FALSE.equals(result)) {
            throw new BaseException(BaseResponseStatus.ALREADY_REGISTER_QUEUE);
        }
    }

    @Override
    public QueueStatus getMyPosition(String queueIdx, Long memberIdx) throws BaseException {
        Long rank = redisTemplate.opsForZSet().rank(queueIdx, String.valueOf(memberIdx));
        Long size = redisTemplate.opsForZSet().size(queueIdx);

        if (rank == null || size == null) {
            throw new BaseException(BaseResponseStatus.NOT_FOUND_RANK_AND_SIZE);
        }
        return QueueStatus.builder()
                .position(rank + 1)
                .backPosition(size - rank - 1)
                .queueIdx(queueIdx)
                .progress(getProgress(size, rank))
                .build();
    }


    @Override
    public RegisterQueueResponse getMyQueue(Long couponIdx) {
        return RegisterQueueResponse.builder().queueIdx(getKey(couponIdx)).inQueue(true).build();
    }

    @Override
    public Boolean isEmpty(Long couponIdx) {
        Long size = redisTemplate.opsForZSet().size(getKey(couponIdx));
        return size == null || size == 0;
    }

    @Override
    public void remove(Long couponIdx, Long memberIdx) {
        redisTemplate.opsForZSet().remove(getKey(couponIdx), memberIdx);
    }

    @Override
    public Double getProgress(Long size, Long rank) {
        if (size <= 0) {
            return 0.0;
        }
        return 100 - (double) rank / size * 100;
    }

    @Override
    public Long moveActiveQueue(String queueIdx, Long count) {
        double time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        String activeQueueKey = getActiveKey(queueIdx);
        Set<String> range = redisTemplate.opsForZSet().range(queueIdx, 0, count - 1);

        if (range == null) return 0L;
        if (range.isEmpty()) return 0L;

        redisTemplate.opsForZSet().remove(queueIdx, range.toArray());
        for (String userId : range) {
            redisTemplate.opsForSet().add(activeQueueKey, userId);
        }
        return (long) range.size();
    }

    @Override
    public Set<String> scanKeys(String pattern) throws BaseException {
        Set<String> keys = new HashSet<>();

        ScanOptions keyScanOptions = ScanOptions.scanOptions()
                .match(pattern)
                .count(1000)
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

    @Override
    public List<String> getWaitingUsers(String queueKey, Long maxToMove) {
        return null;
    }

    @NotNull
    private static String getActiveKey(String queueIdx) {
        return "active:" + queueIdx;
    }

    @NotNull
    private static String getKey(Long couponIdx) {
        return "waiting:" + couponIdx;
    }
}
