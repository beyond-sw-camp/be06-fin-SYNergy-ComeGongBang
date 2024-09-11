package com.synergy.backend.domain.review.model.request;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.review.model.entity.Review;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateReviewReq {
    private String content;
    private Integer score;

    @Builder
    public CreateReviewReq(String content, Integer score) {
        this.content = content;
        this.score = score;
    }

    public Review toEntity(Member member, Product product) {
        return Review
                .builder()
                .member(member)
                .product(product)
                .content(this.content)
                .score(this.score)
                .build();
    }
}
