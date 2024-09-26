package com.synergy.backend.domain.orders.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartProductListRes {
    private Long productIdx;
    private String productName;
    private String productUrl;
    private List<OptionListRes> optionList;
}
