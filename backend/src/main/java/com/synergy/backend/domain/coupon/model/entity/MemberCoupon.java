package com.synergy.backend.domain.coupon.model.entity;

import com.synergy.backend.domain.member.model.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Builder
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


    public static MemberCoupon issued(Coupon coupon, Member member) {
        return MemberCoupon.builder()
                .coupon(coupon)
                .expirationDate(coupon.getUsageTimes())
                .member(member)
                .publicationDate(LocalDateTime.now())
                .build();
    }
}
