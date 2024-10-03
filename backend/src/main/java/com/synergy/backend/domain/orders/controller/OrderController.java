package com.synergy.backend.domain.orders.controller;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.synergy.backend.domain.member.model.response.OrderListRes;
import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.orders.model.request.OrderInfoReq;
import com.synergy.backend.domain.orders.service.OrderService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/list")
    public BaseResponse<List<OrderListRes>> orderList(Integer year, Integer page, Integer size,  @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        if(customUserDetails==null){
            throw  new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        Long memberIdx = customUserDetails.getIdx();
        List<OrderListRes> responses = orderService.orderList(year, page, size, memberIdx);

        return new BaseResponse<>(responses);
    }

    @GetMapping("/pre/validation")
    public BaseResponse<String> preValidation(String impUid,  @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException, IamportResponseException, IOException {
        if(customUserDetails==null){
            throw  new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        Long memberIdx = customUserDetails.getIdx();
        Boolean validation = orderService.confirmOrderBefore(impUid, memberIdx);

        if(!validation){
            return new BaseResponse<>("상품 재고가 없습니다.");
        }
        return new BaseResponse<>("결제 가능");
    }

    @GetMapping("/confirm")
    public BaseResponse<String> confirmOrder(String impUid,  @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException, IamportResponseException, IOException {
        if(customUserDetails==null){
            throw  new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        Long memberIdx = customUserDetails.getIdx();

        orderService.confirmOrder(impUid, memberIdx);
        return new BaseResponse<>("결제 검증");
    }
}
