package com.synergy.backend.domain.orders.model.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PresentRes {
    String member;
    Integer count;
    String date;
    List<PresentProductRes> products;

    @Builder
    public PresentRes(String toMember, Integer count, String date, List<PresentProductRes> products){
        this.member = member;
        this.count = count;
        this.date = date;
        this.products = products;
    }
}
