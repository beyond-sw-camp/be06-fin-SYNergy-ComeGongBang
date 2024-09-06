package com.synergy.backend.coupon.model.entity;

import com.synergy.backend.common.model.BaseEntity;
import com.synergy.backend.member.model.entity.Member;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "coupon")
public class Coupon extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;

    private String name;
    private String type;
    private String code;
    private Integer discountPercent;
    private LocalDateTime publicationDate;
    private LocalDateTime expiration;
    private String minimumOrderPrice;
    private String maximumDiscountPrice;
}
