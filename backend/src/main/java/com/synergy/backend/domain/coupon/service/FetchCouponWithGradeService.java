package com.synergy.backend.domain.coupon.service;

import com.synergy.backend.domain.coupon.model.entity.Coupon;
import com.synergy.backend.domain.coupon.model.type.CouponType;
import com.synergy.backend.domain.coupon.repository.CouponRepository;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FetchCouponWithGradeService {

    private final CouponRepository couponRepository;

    public Coupon findByGradeWithRecur(Long gradeIdx) throws BaseException {
        return couponRepository.findCouponsByGradeWithRecur(gradeIdx, CouponType.RECUR);
    }
}
