package com.synergy.backend.domain.orders.querydsl;

import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.product.model.entity.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderRepositoryCustom {
    Page<Orders> orderList(Integer year, Pageable pageable, Long memberIdx);
}