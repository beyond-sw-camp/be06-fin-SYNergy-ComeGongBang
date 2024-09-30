package com.synergy.backend.domain.orders.service;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.model.response.OrderListRes;
import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.orders.model.request.OrderInfoReq;
import com.synergy.backend.domain.orders.repository.OrderRepository;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import java.io.IOException;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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
    private final ProductRepository productRepository;
//    private final IamportClient iamportClient;

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

    public void confirmOrder(String impUid, Long memberIdx)
            throws BaseException, IamportResponseException, IOException {

        System.out.println(impUid);
        //결제검증
//        IamportResponse<Payment> response = iamportClient.paymentByImpUid(impUid);
//        System.out.println(response);

        //존재하는 상품이 아니면 예외처리
//        Product product = productRepository.findById(req.getProductIdx()).orElseThrow(
//                ()-> new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));
        //요청한 상품 결제 금액과 실재 결제 금액이 동일한지 확인
//        int totalPrice =

//        orderRepository.save(req.toEntity(memberIdx));
    }
}
