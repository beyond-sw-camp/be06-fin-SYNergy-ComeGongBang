package com.synergy.backend.domain.product.model.response;

import com.synergy.backend.domain.atelier.model.response.AtelierProfileInfoRes;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductInfoRes {
    // 상품 idx
    private Long productIdx;
    // 작가 idx
    private Long atelierIdx;
    // 상픔 이름
    private String productName;
    // 상품 썸네일
    private String productThumbnail;
    // 상품 이미지들
    private List<ProductImagesRes> productImages;
    // 상품 원가 (원)
    private int productPrice;
    // 상품 개별 할인률 (%)
    private int productOnSalePercent;
    // 상품 개별 할인률 (원)
    private int productOnSalePrice;
    // 상품 할인 적용가 (원)
    private int productFinalPrice;
    // 상품 평점
    private Double productAverageScore;
    // 상품 옵션들
    private List<ProductMajorOptionsRes> productOptions;
    //  상품 설명
    private String productDescription;
    // 상품 키워드 리스트
    private List<String> productHashTags;
    // 상품 좋아요 갯수
    private Long productLikeCount;
    // 회원이 상품 좋아요 여부
    private Boolean isMemberLiked;
    // 상품 소비기한 / 품질 유지 기한
    private String productExpiration;
    // 상품 제작 = 주문시 제작으로 고정(?)
    private String productManufacturing;

    private AtelierProfileInfoRes atelierProfileInfoRes;

    // 필요 없어진 응답들

    // 상품 배달비
//    private int productDeliveryFee;
    // 상품 유형/카테고리
//    private String productType;

    @Builder
    public ProductInfoRes(String productThumbnail, List<ProductImagesRes> productImages, Long productIdx,
                          Long atelierIdx,
                          String productName, int productPrice, int productOnSalePercent, int productOnSalePrice,
                          int productFinalPrice, Double productAverageScore,
                          List<ProductMajorOptionsRes> productOptions, String productDescription,
                          List<String> productHashTags, Long productLikeCount, boolean isMemberLiked,
                          String productExpiration, String productManufacturing,
                          AtelierProfileInfoRes atelierProfileInfoRes) {
        this.productThumbnail = productThumbnail;
        this.productImages = productImages;
        this.productIdx = productIdx;
        this.atelierIdx = atelierIdx;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productOnSalePercent = productOnSalePercent;
        this.productOnSalePrice = productOnSalePrice;
        this.productFinalPrice = productFinalPrice;
        this.productAverageScore = productAverageScore;
        this.productOptions = productOptions;
        this.productDescription = productDescription;
        this.productHashTags = productHashTags;
        this.productLikeCount = productLikeCount;
        this.isMemberLiked = isMemberLiked;
        this.productExpiration = productExpiration;
        this.productManufacturing = productManufacturing;
        this.atelierProfileInfoRes = atelierProfileInfoRes;
    }
}
