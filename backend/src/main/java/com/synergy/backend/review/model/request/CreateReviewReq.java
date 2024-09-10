package com.synergy.backend.review.model.request;

import com.synergy.backend.member.model.entity.Member;
import com.synergy.backend.product.model.entity.Product;
import com.synergy.backend.review.model.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

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
