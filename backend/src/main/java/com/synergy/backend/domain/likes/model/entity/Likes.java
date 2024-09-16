package com.synergy.backend.domain.likes.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.product.model.entity.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class Likes extends BaseEntity {

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
