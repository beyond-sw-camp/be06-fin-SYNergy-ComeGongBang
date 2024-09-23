package com.synergy.backend.domain.review.model.response;

import com.synergy.backend.domain.review.model.entity.Review;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ProductReviewRes {
    private Long reviewIdx;
    private String nickname;
    private String thumbnailImages;
    private LocalDateTime createdAt;
    private String content;
    private Integer score;

    public ProductReviewRes(Long reviewIdx,
                            String nickname,
                            String thumbnailImages,
                            LocalDateTime createdAt,
                            String content,
                            Integer score) {
        this.reviewIdx = reviewIdx;
        this.nickname = nickname;
        this.thumbnailImages = thumbnailImages;
        this.createdAt = createdAt;
        this.content = content;
        this.score = score;
    }
}
