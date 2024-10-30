package com.synergy.backend.domain.product.model.request;

import lombok.Getter;

@Getter
public class ProductListReq {
    Long idx; //카테고리 idx 또는 hashtag idx
    Integer page;
    Integer size;
    Integer price;
    Integer sort;
}
