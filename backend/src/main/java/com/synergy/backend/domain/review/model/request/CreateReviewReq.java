package com.synergy.backend.domain.review.model.request;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.review.model.entity.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateReviewReq {
    private Long productIdx;
    private Long orderIdx;
    private String content;
    private Integer score;

    @Builder
    public Review toEntity(Member member, Product product, Orders orders) {
        return Review
                .builder()
                .member(member)
                .product(product)
                .content(this.content)
                .score(this.score)
                .orders(orders)
                .build();
    }


}
