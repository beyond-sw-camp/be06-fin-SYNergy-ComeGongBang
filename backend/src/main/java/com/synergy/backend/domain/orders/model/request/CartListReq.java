package com.synergy.backend.domain.orders.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartListReq {
    private List<Long> cartIdxList;
}
