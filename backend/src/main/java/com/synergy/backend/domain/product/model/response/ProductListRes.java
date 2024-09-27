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
    Boolean isMemberliked;
    int likeCounts;

    @Builder
    public ProductListRes(Long idx, String name, int price, String thumbnailUrl, Double averageScore,
                          String atelier_name,
                          String category_name, Boolean isMemberliked, int likeCounts) {
        this.idx = idx;
        this.name = name;
        this.price = price;
        this.thumbnailUrl = thumbnailUrl;
        this.averageScore = averageScore;
        this.atelier_name = atelier_name;
        this.category_name = category_name;
        this.isMemberliked = isMemberliked;
        this.likeCounts = likeCounts;
    }
}
