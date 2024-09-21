package com.synergy.backend.domain.orders.model.response;

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
    private Integer price;       // 가격
    private String productName;  // 상품 이름
    private Long productIdx;      // 상품 ID
    private String atelierName;  // 가게 이름
    private Long atelierIdx;      // 가게 ID
    private String orderMessage;

    public CartDTO(Long cartIdx, Long optionIdx, Long majorOptionIdx, String majorOptionName, Long subOptionIdx, String subOptionName, Integer count, Integer price, String productName, Long productIdx, String atelierName, Long atelierIdx, String orderMessage) {
        this.cartIdx = cartIdx;
        this.optionIdx = optionIdx;
        this.majorOptionIdx = majorOptionIdx;
        this.majorOptionName = majorOptionName;
        this.subOptionIdx = subOptionIdx;
        this.subOptionName = subOptionName;
        this.count = count;
        this.price = price;
        this.productName = productName;
        this.productIdx = productIdx;
        this.atelierName = atelierName;
        this.atelierIdx = atelierIdx;
        this.orderMessage = orderMessage;
    }
}
