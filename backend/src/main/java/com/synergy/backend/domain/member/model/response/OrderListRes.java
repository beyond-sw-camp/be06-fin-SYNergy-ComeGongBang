package com.synergy.backend.domain.member.model.response;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderListRes {
    LocalDateTime date;
    Integer price;
    String imageUrl;
    String name;
    String atelier;
    String state;
    String optionString;

    @Builder
    public OrderListRes(LocalDateTime date, Integer price, String imageUrl, String name, String atelier, String state, String optionString) {
        this.date = date;
        this.price = price;
        this.imageUrl = imageUrl;
        this.name = name;
        this.atelier = atelier;
        this.state = state;
        this.optionString = optionString;
    }
}
