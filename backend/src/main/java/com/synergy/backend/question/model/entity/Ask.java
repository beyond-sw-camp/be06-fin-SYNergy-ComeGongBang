package com.synergy.backend.question.model.entity;

import com.synergy.backend.atelier.model.entity.Atelier;
import com.synergy.backend.common.model.BaseEntity;
import com.synergy.backend.member.model.entity.Member;
import com.synergy.backend.product.model.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ask")
@Getter
@Setter
public class Ask extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_idx")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "atelier_idx")
    private Atelier atelier;

    private String content;
    private boolean isSecret;
    private Long atelierIdx;
    private String ateliername;
    private String atelierProfileImageUrl;
    private String replyContent;

}