package com.synergy.backend.domain.product.model.request;

import lombok.Getter;

@Getter
public class KeywordProductListReq {
    String keyword;
    Integer page;
    Integer size;
    Integer price;
    Integer sort;
}
