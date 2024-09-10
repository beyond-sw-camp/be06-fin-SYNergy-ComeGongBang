package com.synergy.backend.orders.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductListRes {
    private Long productIdx;
    private String productName;
    private Integer count;
    private Integer price;
    private List<OptionListRes> optionList;
}
