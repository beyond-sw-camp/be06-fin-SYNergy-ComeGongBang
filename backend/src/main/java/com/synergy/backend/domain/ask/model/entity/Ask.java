package com.synergy.backend.domain.ask.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.product.model.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ask")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne(mappedBy = "ask", cascade = CascadeType.ALL)
    private Reply reply;

    private String userIdx;
    private String username;
    private String ProfileImageUrl;
    private String content;
    private boolean isSecret;


}