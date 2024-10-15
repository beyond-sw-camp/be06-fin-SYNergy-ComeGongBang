package com.synergy.backend.domain.queue.service;

import com.synergy.backend.domain.queue.model.response.QueueStatus;
import com.synergy.backend.domain.queue.model.response.RegisterQueueResponse;
import com.synergy.backend.global.exception.BaseException;

import java.util.List;
import java.util.Set;

public interface QueueRedisService {

    void save(Long couponIdx, Long memberIdx) throws BaseException;

    QueueStatus getMyPosition(String queueIdx, Long memberIdx) throws BaseException;

    RegisterQueueResponse getMyQueue(Long couponIdx);

    Boolean isEmpty(Long couponIdx);

    void remove(Long couponIdx, Long memberIdx);

    Double getProgress(Long size, Long rank);

    Long moveActiveQueue(String queueIdx, Long count);

    Set<String> scanKeys(String pattern) throws BaseException;

    List<String> getWaitingUsers(String queueKey, Long maxToMove);
}
