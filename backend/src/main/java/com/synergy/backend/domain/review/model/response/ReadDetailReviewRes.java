package com.synergy.backend.domain.review.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReadDetailReviewRes {
    private Long reviewIdx;
    private String nickname;
    private String profileImageUrl;
    private LocalDateTime createdAt;
    private String productName;
    private String thumbnailUrl;
    private String content;
    private Integer score;
}
