package com.synergy.backend.domain.orders.service;

import com.synergy.backend.domain.member.model.response.OrderListRes;
import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.orders.repository.OrderRepository;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<OrderListRes> orderList(Integer year, Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Direction.ASC, "idx"));
        Page<Orders> results = orderRepository.orderList(year, pageable);

        List<OrderListRes> orders = new ArrayList<>();

        for (Orders result : results) {
            orders.add(OrderListRes.builder()
                    .date(result.getCreatedAt())
                    .price(result.getTotalPrice())
                    .imageUrl("")
                    .name(result.getProduct().getName())
                    .atelier(result.getProduct().getAtelier().getName())
                    .state(result.getDeliveryState()).build());
        }

        return orders;
    }
}
