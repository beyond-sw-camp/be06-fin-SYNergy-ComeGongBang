package com.synergy.backend.domain.orders.model.request;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.product.model.entity.Product;
import lombok.Getter;

@Getter
public class OrderInfoReq {
    private String impUid;
}
