package com.synergy.backend.domain.review.model.response;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
@Builder
public class ReviewListResponse {
    private Page<ProductReviewRes> reviewList;
    private Double avgScore;
}
