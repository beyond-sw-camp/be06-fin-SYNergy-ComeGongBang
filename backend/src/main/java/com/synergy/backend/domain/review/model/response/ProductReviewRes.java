package com.synergy.backend.domain.review.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
public class  ProductReviewRes {
    private Long reviewIdx;
    private String nickname;
    private String profileImage;
    private String thumbnailImages;
    private LocalDateTime createdAt;
    private String content;
    private Integer score;

    public ProductReviewRes(Long reviewIdx,
                            String nickname,
                            String profileImage,
                            String thumbnailImages,
                            LocalDateTime createdAt,
                            String content,
                            Integer score) {
        this.reviewIdx = reviewIdx;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.thumbnailImages = thumbnailImages;
        this.createdAt = createdAt;
        this.content = content;
        this.score = score;
    }
}
