package com.synergy.backend.domain.queue.service;

import com.synergy.backend.domain.queue.model.response.QueueStatus;
import com.synergy.backend.domain.queue.model.response.RegisterQueueResponse;
import com.synergy.backend.global.exception.BaseException;

import java.util.Set;

public interface QueueRedisService {

    void save(Long programId, Long userId) throws BaseException;

    QueueStatus getMyPosition(String queueId, Long userId) throws BaseException;

    RegisterQueueResponse getMyQueue(Long programId);

    Boolean isEmpty(Long programId);

    void remove(Long programId, Long userId);

    Double getProgress(Long size, Long rank);

    Long moveActiveQueue(String queueId, Long count);

    Set<String> scanKeys(String pattern) throws BaseException;
}
