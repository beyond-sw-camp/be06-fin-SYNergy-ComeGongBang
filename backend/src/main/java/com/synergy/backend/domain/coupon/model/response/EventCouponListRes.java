package com.synergy.backend.domain.coupon.model.response;

import com.synergy.backend.domain.coupon.model.entity.Coupon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EventCouponListRes {

    private Long couponIdx;
    private String name;
    private Integer discountPercent;
    private LocalDateTime publicationDate; //쿠폰 발급 가능 날짜
    private LocalDateTime expirationDate; //쿠폰 발급 가능 날짜


    public static EventCouponListRes from(Coupon coupon) {
        return EventCouponListRes.builder()
                .couponIdx(coupon.getIdx())
                .name(coupon.getName())
                .discountPercent(coupon.getDiscountPercent())
                .publicationDate(coupon.getIssueDate().getStartedAt())
                .expirationDate(coupon.getIssueDate().getFinishedAt())
                .build();
    }
}
