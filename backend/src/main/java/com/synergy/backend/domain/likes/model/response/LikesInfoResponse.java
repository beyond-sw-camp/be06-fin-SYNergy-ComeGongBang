package com.synergy.backend.domain.likes.model.response;

import lombok.Builder;

@Builder
public class LikesInfoResponse {
    private boolean memberIsLiked;
    private int productLikesCount;
    private int atelierHavingProductsLikesCount;
}
