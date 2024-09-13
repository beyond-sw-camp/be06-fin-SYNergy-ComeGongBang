package com.synergy.backend.domain.product.model.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SearchProductRes {
    Long idx;
    String name;
    int price;
    String thumbnailUrl;
    Double averageScore;
    String atelier_name;
    String category_name;
}
