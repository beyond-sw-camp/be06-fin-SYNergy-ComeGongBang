package com.synergy.backend.domain.likes.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.product.model.entity.Product;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "likes")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
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


    // 새 생성자 추가 member,product인자로 받기
    public Likes(Member member, Product product) {
        this.member = member;
        this.product = product;
    }
}
