package com.synergy.backend.domain.orders.model.request;

import lombok.Getter;

@Getter
public class OrderPresentReq {
    String toMemberEmail;
    String message;
}
