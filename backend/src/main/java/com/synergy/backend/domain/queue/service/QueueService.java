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

    @Value("${queue.enabled}")
    private Boolean scheduling;

    public RegisterQueueResponse enterWaitQueue(Long couponIdx, Long userId) throws BaseException {
        queueRedisService.save(couponIdx, userId);
        return queueRedisService.getMyQueue(couponIdx);
    }

    public Boolean isWaitQueueNecessary(Long couponIdx) {
        return queueRedisService.isWaitQueueNecessary(couponIdx);
    }

    public QueueStatus getRank(String queueIdx, Long memberIdx) throws BaseException {
        QueueStatus myPosition = queueRedisService.getMyPosition(queueIdx, memberIdx);
        Long couponIdx = Long.valueOf(queueIdx.split(":")[1]);
        if (myPosition == null) {
            myPosition = queueRedisService.checkFinishQueue(couponIdx, memberIdx);
        }
        return myPosition;
    }

    //대기 -> 활성
    @Scheduled(fixedDelayString = "${queue.fixed-delay}")
    public void scheduleIssuedCoupon() throws BaseException {
        if (!scheduling) {
            return;
        }
        Set<String> queueKeys = queueRedisService.scanKeys("waiting:*");

        for (String queueIdx : queueKeys) {
            try {
                queueRedisService.moveActiveQueue(queueIdx);

                log.info("move user {} to active", queueIdx.split(":")[1]);
            } catch (Exception e) {
                log.error("Failed to move {}: {}", queueIdx, e.getMessage());
            }
        }
    }

    public void deleteWaitQueue(String queueIdx, Long memberIdx) {
        queueRedisService.deleteWaitQueue(queueIdx, memberIdx);
    }

    public void deleteActiveQueue(Long couponIdx, Long memberIdx) {
        queueRedisService.deleteActiveQueue(memberIdx, couponIdx);
    }

    public void enterFinishQueueFromActive(Long couponIdx, Long memberIdx) {
        queueRedisService.deleteActiveQueue(memberIdx, couponIdx);
        queueRedisService.registFinishQueue(memberIdx, couponIdx);
    }

    public void enterActiveQueue(Long couponIdx, Long memberIdx) {
        queueRedisService.registActiveQueue(memberIdx, couponIdx);
    }
}
