package com.synergy.backend.domain.orders.service;

import com.synergy.backend.domain.orders.model.request.AddCartReq;

import java.util.List;

public interface AddCartStrategy {

    List<Long> addCart(Long memberIdx, List<AddCartReq> reqs);
}
