package com.synergy.backend.domain.coupon.controller;

import com.synergy.backend.domain.coupon.scheduler.CouponScheduler;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage/coupon")
public class CouponController {

    private final CouponScheduler couponScheduler;

    //내 쿠폰 조회, 페이징 처리

    //쿠폰 발급 스케줄러 테스트용
    @GetMapping("/test")
    public String coupon() throws BaseException {
        couponScheduler.issuedCoupon();
        return "성공";
    }


}
