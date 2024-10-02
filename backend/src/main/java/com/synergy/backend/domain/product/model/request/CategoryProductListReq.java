package com.synergy.backend.domain.product.model.request;

import lombok.Getter;

@Getter
public class CategoryProductListReq {
    Long categoryIdx;
    Integer page;
    Integer size;
    Integer priceCondition;
    Integer sortCondition;
}
