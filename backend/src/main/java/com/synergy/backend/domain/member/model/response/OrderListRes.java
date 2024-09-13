package com.synergy.backend.domain.member.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderListRes {
    String date;
    Integer price;
    String imageUrl;
    String name;
    String atelier;
    String state;

    @Builder
    public OrderListRes(String date, Integer price, String imageUrl, String name, String atelier, String state) {
        this.date = date;
        this.price = price;
        this.imageUrl = imageUrl;
        this.name = name;
        this.atelier = atelier;
        this.state = state;
    }
}
