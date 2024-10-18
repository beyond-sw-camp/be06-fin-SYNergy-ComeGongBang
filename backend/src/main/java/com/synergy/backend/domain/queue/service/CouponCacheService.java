package com.synergy.backend.domain.queue.service;

import com.synergy.backend.domain.coupon.model.entity.Coupon;
import com.synergy.backend.domain.coupon.repository.CouponRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponCacheService {

    private final CouponRepository couponRepository;

    @Cacheable(value = "coupons", key = "#couponIdx")
    public Coupon getCouponFromCache(Long couponIdx) throws BaseException {
        return couponRepository.findById(couponIdx)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.COUPON_NOT_FOUND));
    }

}
