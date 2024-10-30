package com.synergy.backend.domain.coupon.controller;

import com.synergy.backend.domain.coupon.model.response.EventCouponListRes;
import com.synergy.backend.domain.coupon.model.response.MyCouponListRes;
import com.synergy.backend.domain.coupon.scheduler.CouponScheduler;
import com.synergy.backend.domain.coupon.service.CouponService;
import com.synergy.backend.domain.queue.model.response.RegisterQueueResponse;
import com.synergy.backend.domain.queue.service.QueueService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage/coupon")
public class CouponController {

    private final CouponScheduler couponScheduler;
    private final CouponService couponService;
    private final QueueService queueService;
    private final RedissonClient redissonClient;
    @Value("${queue.necessary}")
    private Boolean queueNecessaryConfig;

    @PostMapping("/{couponIdx}/issue")
    public BaseResponse<RegisterQueueResponse> issueCoupon(@PathVariable Long couponIdx,
                                                           @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        if (customUserDetails == null) {
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }

        couponService.validateCouponIssue(customUserDetails.getIdx(), couponIdx);

        //TODO 내부에서 확인?
        Boolean queueNecessary = queueService.isWaitQueueNecessary(couponIdx);
        if (queueNecessaryConfig || queueNecessary) {
            //대기열
            RegisterQueueResponse registerQueueResponse
                    = queueService.enterWaitQueue(couponIdx, customUserDetails.getIdx());
            return new BaseResponse<>(BaseResponseStatus.QUEUE_ENTERED, registerQueueResponse);
        } else {
            //활성화열
            queueService.enterActiveQueue(couponIdx, customUserDetails.getIdx());
            try {
                couponService.issueCoupon(customUserDetails.getIdx(), couponIdx);
                queueService.enterFinishQueueFromActive(couponIdx, customUserDetails.getIdx());
            } catch (BaseException e) {
                throw new BaseException(BaseResponseStatus.FAIL_ISSUED_COUPON);
            } finally {
                queueService.deleteActiveQueue(couponIdx, customUserDetails.getIdx());
            }
            return new BaseResponse<>(BaseResponseStatus.COUPON_ISSUED);
        }
    }


    //내 쿠폰 조회, 페이징 처리
    @GetMapping("/me")
    public BaseResponse<List<MyCouponListRes>> getMyCouponList(@AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        if (customUserDetails == null) {
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        List<MyCouponListRes> result = couponService.getMyCouponList(customUserDetails.getIdx());
        return new BaseResponse<>(result);
    }

    //이벤트 쿠폰 목록 조회
    @GetMapping("/event")
    public BaseResponse<List<EventCouponListRes>> getEventCouponList() {
        List<EventCouponListRes> result = couponService.getEventCouponList();
        return new BaseResponse<>(result);
    }


    //쿠폰 발급 스케줄러 테스트용
    @GetMapping("/test")
    public String coupon() throws BaseException {
        couponScheduler.issuedCoupon();
        return "성공";
    }


}
