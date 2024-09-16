package com.synergy.backend.domain.orders.controller;

import com.synergy.backend.domain.member.model.response.OrderListRes;
import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.orders.service.OrderService;
import com.synergy.backend.global.common.BaseResponse;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/list")
    public BaseResponse<List<OrderListRes>> orderList(Integer year, Integer page, Integer size){
        List<OrderListRes> responses = orderService.orderList(year, page, size);

        return new BaseResponse<>(responses);
    }
}
