package com.synergy.backend.domain.queue.service;

import com.synergy.backend.domain.queue.model.response.QueueStatus;
import com.synergy.backend.domain.queue.model.response.RegisterQueueResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class QueueRedisServiceImpl implements QueueRedisService {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public void save(Long programId, Long userId) throws BaseException {
        double score = (double) LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        Boolean result = redisTemplate.opsForZSet().addIfAbsent(getKey(programId), String.valueOf(userId), score);
        if (Boolean.FALSE.equals(result)) {
            throw new BaseException(BaseResponseStatus.ALREADY_REGISTER_QUEUE);
        }
    }

    @Override
    public QueueStatus getMyPosition(String queueId, Long userId) throws BaseException {
        Long rank = redisTemplate.opsForZSet().rank(queueId, String.valueOf(userId));
        Long size = redisTemplate.opsForZSet().size(queueId);

        if (rank == null || size == null) {
            throw new BaseException(BaseResponseStatus.NOT_FOUND_RANK_AND_SIZE);
        }
        return QueueStatus.builder()
                .position(rank + 1)
                .backPosition(size - rank - 1)
                .queueId(queueId)
                .progress(getProgress(size, rank))
                .build();
    }


    @Override
    public RegisterQueueResponse getMyQueue(Long programId) {
        return RegisterQueueResponse.builder().queueId(getKey(programId)).inQueue(true).build();
    }

    @Override
    public Boolean isEmpty(Long programId) {
        Long size = redisTemplate.opsForZSet().size(getKey(programId));
        return size == null || size == 0;
    }

    @Override
    public void remove(Long programId, Long userId) {
        redisTemplate.opsForZSet().remove(getKey(programId), userId);
    }

    @Override
    public Double getProgress(Long size, Long rank) {
        if (size <= 0) {
            return 0.0;
        }
        return 100 - (double) rank / size * 100;
    }

    @Override
    public Long moveActiveQueue(String queueId, Long count) {
        double time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        String activeQueueKey = getActiveKey(queueId);
        Set<String> range = redisTemplate.opsForZSet().range(queueId, 0, count - 1);

        if (range == null) return 0L;
        if (range.isEmpty()) return 0L;

        redisTemplate.opsForZSet().remove(queueId, range.toArray());
        for (String userId : range) {
            redisTemplate.opsForSet().add(activeQueueKey, userId);
        }
        return (long) range.size();
    }

    @Override
    public Set<String> scanKeys(String pattern) throws BaseException {
        Set<String> keys = new HashSet<>();
        ScanOptions scanOptions = ScanOptions.scanOptions().match(pattern).count(1000).build();

        try (Cursor<byte[]> cursor = Objects.requireNonNull(redisTemplate.getConnectionFactory()).getConnection().scan(scanOptions)) {
            while (cursor.hasNext()) {
                keys.add(new String(cursor.next()));
            }
        } catch (Exception e) {
            throw new BaseException(BaseResponseStatus.FAIL_LOAD_SCAN_REDIS);
        }

        return keys;
    }

    @NotNull
    private static String getActiveKey(String queueId) {
        return "active:" + queueId;
    }

    @NotNull
    private static String getKey(Long programId) {
        return "waiting:" + programId;
    }
}
