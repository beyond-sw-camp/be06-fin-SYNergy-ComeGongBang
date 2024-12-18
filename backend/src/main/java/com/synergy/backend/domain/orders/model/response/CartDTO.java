package com.synergy.backend.domain.orders.model.response;

import java.security.PrivateKey;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class CartDTO {

    private Long cartIdx;
    private Long optionIdx;       // 옵션 ID
    private Long majorOptionIdx;  // 주요 옵션 ID
    private String majorOptionName; // 주요 옵션 이름
    private Long subOptionIdx;    // 세부 옵션 ID
    private String subOptionName; // 세부 옵션 이름
    private Integer count;       // 수량
    private Integer price;       // 옵션 추가 가격
    private Integer productPrice; // 상품 원래 가격
    private String productName;  // 상품 이름
    private Integer salePercent; // 상품 할인률
    private Long productIdx;      // 상품 ID
    private String productUrl;    // 상품 사진
    private String atelierName;  // 가게 이름
    private Long atelierIdx;      // 가게 ID
    private String orderMessage;

    public CartDTO(Long cartIdx,
                   Long optionIdx,
                   Long majorOptionIdx,
                   String majorOptionName,
                   Long subOptionIdx,
                   String subOptionName,
                   Integer count,
                   Integer price,
                   Integer productPrice,
                   String productName,
                   Integer salePercent,
                   Long productIdx,
                   String productUrl,
                   String atelierName,
                   Long atelierIdx,
                   String orderMessage) {
        this.cartIdx = cartIdx;
        this.optionIdx = optionIdx;
        this.majorOptionIdx = majorOptionIdx;
        this.majorOptionName = majorOptionName;
        this.subOptionIdx = subOptionIdx;
        this.subOptionName = subOptionName;
        this.count = count;
        this.productPrice = productPrice;
        this.price = price;
        this.productName = productName;
        this.salePercent = salePercent;
        this.productIdx = productIdx;
        this.productUrl = productUrl;
        this.atelierName = atelierName;
        this.atelierIdx = atelierIdx;
        this.orderMessage = orderMessage;
    }
}
