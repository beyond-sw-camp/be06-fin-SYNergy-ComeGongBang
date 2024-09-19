package com.synergy.backend.domain.product.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductListRes {
    Long idx;
    String name;
    int price;
    String thumbnailUrl;
    Double averageScore;
    String atelier_name;
    String category_name;

    @Builder
    public ProductListRes(Long idx, String name, int price, String thumbnailUrl, Double averageScore,
                          String atelier_name,
                          String category_name) {
        this.idx = idx;
        this.name = name;
        this.price = price;
        this.thumbnailUrl = thumbnailUrl;
        this.averageScore = averageScore;
        this.atelier_name = atelier_name;
        this.category_name = category_name;
    }
}
