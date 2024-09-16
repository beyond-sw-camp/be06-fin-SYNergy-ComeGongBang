package com.synergy.backend.domain.review.model.entity;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idx")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_idx")
    private Product product;

    private String content;
    private Integer score;
}