package com.synergy.backend.domain.product.model.response;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductMajorOptionsRes {

    private Long idx;
    private String name;
    private List<ProductSubOptionsRes> subOptions;

}
