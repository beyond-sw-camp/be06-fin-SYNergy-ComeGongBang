package com.synergy.backend.domain.orders.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OptionListRes {
    private Long cartIdx;
    private String orderMessage;
    private Integer count;
    private Integer price;
    private List<SubOptionsRes> subOptionsList;
}
