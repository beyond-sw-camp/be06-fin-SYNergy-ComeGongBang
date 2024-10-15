package com.synergy.backend.domain.coupon.controller;

import com.synergy.backend.domain.coupon.model.response.EventCouponListRes;
import com.synergy.backend.domain.coupon.model.response.MyCouponListRes;
import com.synergy.backend.domain.coupon.scheduler.CouponScheduler;
import com.synergy.backend.domain.coupon.service.CouponService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage/coupon")
public class CouponController {

    private final CouponScheduler couponScheduler;
    private final CouponService couponService;

    @PostMapping("/{couponIdx}/issue")
    public BaseResponse<Void> issueCoupon(@PathVariable Long couponIdx,
                                          @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        if (customUserDetails.getIdx() == null) {
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        couponService.issueCoupon(customUserDetails.getIdx(), couponIdx);
        return new BaseResponse<>(BaseResponseStatus.COUPON_ISSUED);
    }


    //내 쿠폰 조회, 페이징 처리
    @GetMapping("/me")
    public BaseResponse<List<MyCouponListRes>> getMyCouponList(@AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        if (customUserDetails.getIdx() == null) {
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        List<MyCouponListRes> result = couponService.getMyCouponList(customUserDetails.getIdx());
        return new BaseResponse<>(result);
    }

    //이벤트 쿠폰 목록 조회
    @GetMapping("/event")
    public BaseResponse<List<EventCouponListRes>> getEventCouponList(){
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
