package com.synergy.backend.domain.review.model.response;

import com.synergy.backend.domain.review.model.entity.Review;
import com.synergy.backend.domain.review.model.entity.ReviewImages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReadDetailReviewRes {
    private Long reviewIdx;
    private String nickname;
    private LocalDateTime createdAt;
    private String productName;
    private List<String> imageUrls;
    private String content;
    private Integer score;

    public static ReadDetailReviewRes from(Long reviewIdx, Review review) {
        return ReadDetailReviewRes.builder()
                .reviewIdx(reviewIdx)
                .nickname(review.getMember().getNickname())
                .createdAt(review.getCreatedAt())
                .productName(review.getProduct().getName())
                .imageUrls(review.getReviewImages() != null ?
                        review.getReviewImages().stream()
                                .map(ReviewImages::getImageUrl)
                                .collect(Collectors.toList()) :
                        Collections.emptyList())
                .content(review.getContent())
                .score(review.getScore())
                .build();
    }
}
