package com.synergy.backend.domain.review.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Getter
@NoArgsConstructor
public class MyReviewListRes {
    private Long reviewIdx;
    private Long productIdx;
    private String productName;
    private String thumbnailImages;
    private LocalDateTime createdAt;
    private String content;
    private Integer score;

    public MyReviewListRes(Long reviewIdx, Long productIdx, String productName, String thumbnailImages, LocalDateTime createdAt, String content, Integer score) {
        this.reviewIdx = reviewIdx;
        this.productIdx = productIdx;
        this.productName = productName;
        this.thumbnailImages = thumbnailImages;
        this.createdAt = createdAt;
        this.content = content;
        this.score = score;
    }
}
