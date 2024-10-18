package com.synergy.backend.domain.product.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductListRes {
    private Long idx;
    private String name;
    private int price;
    private String thumbnailUrl;
    private Double averageScore;
    private int onSalePercent;
    private String atelierName;
    private Boolean isMemberLiked;
    private Long likeCounts;

    //    private String categoryName;  //TODO : 필요 유무 판단하기

    @Builder
    public ProductListRes(Long idx, String name, int price, String thumbnailUrl, Double averageScore,
                          String atelierName, int onSalePercent,
                          Boolean isMemberLiked, Long likeCounts) {
        this.idx = idx;
        this.name = name;
        this.price = price;
        this.thumbnailUrl = thumbnailUrl;
        this.averageScore = averageScore;
        this.onSalePercent = onSalePercent;
        this.atelierName = atelierName;
        this.isMemberLiked = isMemberLiked;
        this.likeCounts = likeCounts;
    }

    public static ProductListRes from(Long idx, String name, int price, String thumbnailUrl, Double averageScore, int onSalePercent,
                                      String atelierName, Boolean isMemberLiked) {
        return ProductListRes
                .builder()
                .idx(idx)
                .name(name)
                .price(price)
                .thumbnailUrl(thumbnailUrl)
                .averageScore(averageScore)
                .onSalePercent(onSalePercent)
                .atelierName(atelierName)
                .isMemberLiked(isMemberLiked)
                .build();
    }
}
