package com.synergy.backend.domain.review.model.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
@Builder
public class ReviewListResponse {
    private Page<ProductReviewRes> reviewList;
    private Page<String> reviewImages;
    private Double avgScore;
}
