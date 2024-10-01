package com.synergy.backend.domain.orders.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
import java.lang.reflect.Type;
import java.util.*;
import java.util.Map.Entry;
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

    public void confirmOrder(String impUid, Long memberIdx, IamportResponse<Payment> response)
            throws BaseException, IamportResponseException, IOException {

        //커스텀 데이터를 Map형식으로 변환
        // Gson을 이용해 JSON 문자열을 Map 객체로 변환
        String customData = response.getResponse().getCustomData();


        //결제 검증
        //productIdx, productIdx의 옵션에 대한 suboptionIdx, 해당 옵션 조합의 수량을 객체화
    }

    private void jsonproccesor(String customData){
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
        List<Map<String, Object>> customDataList = gson.fromJson(customData, listType);
        System.out.println(customDataList);

        List<OptionData> optionDataList = new ArrayList<>();

    }

    private class OptionData{
        Long productIdx;
        Long majorIdx;
        Long subIdx;
        Integer count;
    }
}
