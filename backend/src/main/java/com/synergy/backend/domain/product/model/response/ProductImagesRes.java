package com.synergy.backend.domain.product.model.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductImagesRes {
    private Long productImageIdx;
    private String productImageUrl;
}
