package com.synergy.backend.domain.coupon.service;

import com.synergy.backend.domain.coupon.model.entity.Coupon;
import com.synergy.backend.domain.coupon.model.entity.MemberCoupon;
import com.synergy.backend.domain.coupon.repository.CouponRepository;
import com.synergy.backend.domain.coupon.repository.MemberCouponRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final MemberCouponRepository memberCouponRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void issueCoupon(Long memberIdx, Long couponIdx) throws BaseException {
        Member member = memberRepository.findById(memberIdx)
                .orElseThrow(() ->
                        new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

        Coupon coupon = couponRepository.findByWithPessimisticLock(couponIdx)
                .orElseThrow(() ->
                        new BaseException(BaseResponseStatus.COUPON_NOT_FOUND));

        if (!coupon.isAvailable()) {
            throw new BaseException(BaseResponseStatus.COUPON_SOLD_OUT);
        }
        coupon.getIssueDate().validate(LocalDateTime.now());

        coupon.increaseCouponQuantity();

        MemberCoupon issued = MemberCoupon.issued(coupon, member);
        memberCouponRepository.save(issued);


    }
}
