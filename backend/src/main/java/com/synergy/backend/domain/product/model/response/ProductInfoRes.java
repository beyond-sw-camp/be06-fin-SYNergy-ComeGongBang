package com.synergy.backend.domain.product.model.response;

import com.synergy.backend.domain.hashtag.model.entity.ProductHashtag;
import com.synergy.backend.domain.product.model.entity.ProductImages;
import com.synergy.backend.domain.product.model.entity.ProductMajorOptions;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductInfoRes {

//        상품 썸네일
    private String productThumbnail;
//        상품 이미지들
    private List<ProductImagesRes> productImages;
//        상품 idx
    private Long productIdx;
//        상픔 이름
    private String productName;
//        상품 가격
    private int productPrice;
//        상품 개별 할인률

//        상품 옵션들
    private List<ProductMajorOptions> productOptions;
//        상품 평점
    private Double productAverageScore;
//        상품 설명
    private String productDescription;
//        상품 배달비
    private int productDeliveryFee;
//        상품 카테고리
    private List<ProductHashtag> productHashTags;
//        좋아요 갯수
    private int productLikeCount;
//        회원이 좋아요 여부
    private boolean memberIsLike;
//        공방 이름
    private String atelierName;
//        공방 이미지
    private String atelierProfileImage;

    private String productType;
    private String productExpiration;
    private String productManufacturing;

    @Builder
    public ProductInfoRes(String productThumbnail, List<ProductImagesRes> productImages, Long productIdx, String productName,
                          int productPrice, List<ProductMajorOptions> productOptions, Double productAverageScore,
                          String productDescription, int productDeliveryFee, List<ProductHashtag> productHashTags,
                          int productLikeCount, boolean memberIsLike, String atelierName, String atelierProfileImage,
                          String productType, String productExpiration, String productManufacturing) {
        this.productThumbnail = productThumbnail;
        this.productImages = productImages;
        this.productIdx = productIdx;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productOptions = productOptions;
        this.productAverageScore = productAverageScore;
        this.productDescription = productDescription;
        this.productDeliveryFee = productDeliveryFee;
        this.productHashTags = productHashTags;
        this.productLikeCount = productLikeCount;
        this.memberIsLike = memberIsLike;
        this.atelierName = atelierName;
        this.atelierProfileImage = atelierProfileImage;
        this.productType = productType;
        this.productExpiration = productExpiration;
        this.productManufacturing = productManufacturing;
    }
}
