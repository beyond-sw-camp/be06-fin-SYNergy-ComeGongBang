package com.synergy.backend.domain.coupon.model.entity;

import com.synergy.backend.domain.member.model.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import lombok.Setter;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private LocalDateTime publicationDate;
    private LocalDateTime expirationDate;

    @ManyToOne
    @JoinColumn(name = "coupon_idx")
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;

    @Setter
    private Boolean isUsed = false;


    public static MemberCoupon issued(Coupon coupon, Member member) {
        return MemberCoupon.builder()
                .coupon(coupon)
                .expirationDate(LocalDateTime.now().plusDays(coupon.getUsageTimes()))
                .member(member)
                .publicationDate(LocalDateTime.now())
                .build();
    }
}
