package com.synergy.backend.domain.review.model.response;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.product.model.entity.Product;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReadDetailReviewRes {
    private Long idx;
    private Member member;
    private Product product;
    private String content;
    private Integer score;
}
