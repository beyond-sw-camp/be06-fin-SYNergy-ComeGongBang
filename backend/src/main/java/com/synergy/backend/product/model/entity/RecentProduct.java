package com.synergy.backend.product.model.entity;

import com.synergy.backend.common.model.BaseEntity;
import com.synergy.backend.member.model.entity.Member;
import jakarta.persistence.*;

@Entity
@Table(name = "recent_product")
public class RecentProduct extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_idx")
    private Product product;

}
