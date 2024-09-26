package com.synergy.backend.domain.orders.service;

import com.synergy.backend.domain.orders.model.request.AddCartReq;

import java.util.List;

public class AddCartStrategyWithoutDuplication implements AddCartStrategy{

    @Override
    public List<Long> addCart(Long memberIdx, List<AddCartReq> reqs) {
        return List.of();
    }
}
