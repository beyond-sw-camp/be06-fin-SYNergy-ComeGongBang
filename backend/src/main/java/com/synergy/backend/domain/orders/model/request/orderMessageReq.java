package com.synergy.backend.domain.orders.model.request;

import lombok.Getter;

import java.util.List;

@Getter
public class orderMessageReq {

    private List<Long> cartIdx;
    private String message;

}
