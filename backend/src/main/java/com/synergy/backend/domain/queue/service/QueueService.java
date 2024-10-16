package com.synergy.backend.domain.queue.service;

import com.synergy.backend.domain.coupon.service.CouponService;
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
    private final CouponService couponService;

    @Value("${queue.max-to-move}")
    private final Long maxToMove = 10L;

    @Value("${queue.enabled}")
    private Boolean scheduling;


    public RegisterQueueResponse enterQueue(Long couponIdx, Long userId) throws BaseException {

        if (!isQueueNecessary(couponIdx)) {
            return RegisterQueueResponse.builder().build();
        }
        queueRedisService.save(couponIdx, userId);
        RegisterQueueResponse myQueue = queueRedisService.getMyQueue(couponIdx);

        return myQueue;
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
        QueueStatus myPosition = queueRedisService.getMyPosition(queueIdx, memberIdx);
        Long couponIdx = Long.valueOf(queueIdx.split(":")[1]);
        System.out.println("couponIdx = " + couponIdx);
        if (myPosition == null) {
            myPosition = queueRedisService.checkActiveQueue(couponIdx, memberIdx);
        }

        return myPosition;
    }


    @Scheduled(fixedDelayString = "${queue.fixed-delay}")
    public void scheduleIssuedCoupon() throws BaseException {
        if (!scheduling) {
            return;
        }
        Set<String> queueKeys = queueRedisService.scanKeys("waiting:*");

        for (String queueIdx : queueKeys) {
            try {
                // 쿠폰 발급 후 활성화 열로
                Long issuedCount = couponService.issueCoupons(queueIdx, maxToMove);
                // 발급 후 활성화 열 이동 코드
                Long count = queueRedisService.moveActiveQueue(queueIdx, maxToMove);
                log.info("issued coupon users : {}", queueIdx);
            } catch (Exception e) {
                log.error("Failed to move {}: {}", queueIdx, e.getMessage());
            }

        }
    }


    public void deleteWaiting(String queueIdx, Long memberIdx) {
        queueRedisService.deleteQueue(queueIdx, memberIdx);
    }
}
