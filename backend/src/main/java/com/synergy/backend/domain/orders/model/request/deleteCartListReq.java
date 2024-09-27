package com.synergy.backend.domain.orders.model.request;

import lombok.Getter;

import java.util.List;

@Getter
public class deleteCartListReq {

    List<Long> cartIdx;
}
