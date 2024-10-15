package com.synergy.backend.domain.coupon.service;

import com.synergy.backend.domain.coupon.model.entity.Coupon;
import com.synergy.backend.domain.coupon.model.entity.MemberCoupon;
import com.synergy.backend.domain.coupon.repository.MemberCouponRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberCouponService {

    private final MemberCouponRepository memberCouponRepository;

    public void publish(LocalDateTime publicationDate,
                        LocalDateTime expirationDate,
                        Member member, Coupon coupon) {
        memberCouponRepository.save(MemberCoupon
                .builder()
                .member(member)
                .coupon(coupon)
                .publicationDate(publicationDate)
                .expirationDate(expirationDate)
                .build()
        );
    }
}
