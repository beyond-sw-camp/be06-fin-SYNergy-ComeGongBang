package com.synergy.backend.domain.likes.model.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LikesInfoResponse {
    private boolean memberIsLiked;
    private Long productLikesCount;
    private int atelierHavingProductsLikesCount;
}
