package com.synergy.backend.domain.orders.model.request;

import lombok.Getter;

@Getter
public class OrderConfirmReq {
    String impUid;
    OrderPresentReq present;
}
