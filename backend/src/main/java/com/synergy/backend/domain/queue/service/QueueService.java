package com.synergy.backend.domain.queue.service;

import com.synergy.backend.domain.queue.model.response.QueueStatus;
import com.synergy.backend.domain.queue.model.response.RegisterQueueResponse;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class QueueService {


    private final QueueRedisService queueRedisService;
    private final Long maxToMove = 10L;

    @Value("${scheduler.enabled}")
    private Boolean scheduling;


    public RegisterQueueResponse enterQueue(Long couponIdx, Long userId) throws BaseException {

        if (!isQueueNecessary(couponIdx)) {
            return RegisterQueueResponse.builder().build();
        }
        queueRedisService.save(couponIdx, userId);
        RegisterQueueResponse myQueue = queueRedisService.getMyQueue(couponIdx);

        return myQueue;

//        return RegisterQueueResponse
//                .builder()
//                .inQueue(true)
//                .build();
    }


    public Boolean isQueueNecessary(Long couponIdx) {
        //나중에 트래픽 코드 추가, 활성화 큐에 있지 않아야 함
        // 트래픽이 몰리면 -> true
        // 활성화 큐에 있으면 ->  false
//        if (redisPort.isEmpty(couponIdx)) {
//            return false;
//        }
        return true;
    }


    public QueueStatus getRank(String queueIdx, Long memberIdx) throws BaseException {
        return queueRedisService.getMyPosition(queueIdx, memberIdx);
    }


    @Scheduled(initialDelay = 1000, fixedDelay = 3000)
    public void scheduleActiveQueue() throws BaseException {
        if (!scheduling) {
            return;
        }
        Set<String> queueKeys = queueRedisService.scanKeys("waiting:*");

        for (String queueKey : queueKeys) {
            try {
                // 각 대기열에서 maxToMove 만큼 활성화 큐로
                Long movedCount = queueRedisService.moveActiveQueue(queueKey, maxToMove);
                log.info("Move {} users from {} to active queue.", movedCount, queueKey);
            } catch (Exception e) {
                log.error("Failed to move {}: {}", queueKey, e.getMessage());
            }
        }
    }
}
