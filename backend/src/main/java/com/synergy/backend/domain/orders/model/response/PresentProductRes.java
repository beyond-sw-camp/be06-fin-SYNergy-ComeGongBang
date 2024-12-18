package com.synergy.backend.domain.orders.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PresentProductRes {
    String state;
    Long productIdx;
    String productName;
    Long atelierIdx;
    String atelierName;
    String imageUrl;

    @Builder
    public PresentProductRes(String state, Long productIdx, String productName, Long atelierIdx, String atelierName,String imageUrl) {
        this.state = state;
        this.productIdx = productIdx;
        this.productName = productName;
        this.atelierIdx = atelierIdx;
        this.atelierName = atelierName;
        this.imageUrl = imageUrl;
    }
}
