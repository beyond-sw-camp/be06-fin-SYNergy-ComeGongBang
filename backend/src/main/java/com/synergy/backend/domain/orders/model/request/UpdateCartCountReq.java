package com.synergy.backend.domain.orders.model.request;

import lombok.Getter;

@Getter
public class UpdateCartCountReq {

    private Long cartIdx;
    private Integer count;
}
