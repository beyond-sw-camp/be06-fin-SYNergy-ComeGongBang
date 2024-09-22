package com.synergy.backend.domain.coupon.model.entity;

import com.synergy.backend.domain.coupon.model.type.CouponType;
import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "coupon")
public class Coupon extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;
    @Enumerated(EnumType.STRING)
    private CouponType type;

    private String code;
    private Integer discountPercent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_idx")
    private Grade grade;
}
