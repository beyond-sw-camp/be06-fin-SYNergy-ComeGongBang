package com.synergy.backend.domain.coupon.model.entity;

import com.synergy.backend.domain.coupon.model.type.CouponType;
import com.synergy.backend.domain.coupon.model.type.IssueDate;
import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    private Integer totalQuantity;
    @Builder.Default
    private Integer issuedQuantity = 0;
    @Embedded
    private IssueDate issueDate;

    // 사용 기간 (플러스 시킬 용도)
    private Long usageTimes;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_idx", nullable = true)
    private Grade grade;


    // 발급 가능,수량 제한 없을 때, 선착순 쿠폰이면 수량이 남아있을 때
    public boolean isAvailable() {
        return totalQuantity == null || issuedQuantity < totalQuantity;
    }

    public void increaseCouponQuantity() {
        if (this.totalQuantity != null
                && this.issuedQuantity < this.totalQuantity) {
            this.issuedQuantity++;
        }
    }

}
