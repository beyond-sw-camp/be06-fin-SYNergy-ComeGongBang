package com.synergy.backend.domain.review.model.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ReadListReviewRes {
    private Long idx;
    private String nickname;
    private String profileImageUrl;
    private LocalDateTime createdAt;
    private String imageUrl;
    private String content;
    private Integer score;
}
