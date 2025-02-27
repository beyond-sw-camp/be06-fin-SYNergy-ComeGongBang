package com.synergy.backend.domain.orders.controller;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import com.synergy.backend.domain.member.model.response.OrderListRes;
import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.orders.model.request.OrderConfirmReq;
import com.synergy.backend.domain.orders.model.request.OrderInfoReq;
import com.synergy.backend.domain.orders.model.response.PreValidationRes;
import com.synergy.backend.domain.orders.model.response.isWritableRes;
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

    @PostMapping("/pre/validation")
    public BaseResponse<PreValidationRes> preValidation(@RequestBody List<Long> cartIds, @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException, IamportResponseException, IOException {
        if(customUserDetails==null){
            throw  new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        Long memberIdx = customUserDetails.getIdx();
        PreValidationRes result = orderService.confirmOrderBefore(cartIds, memberIdx);

        return new BaseResponse<>(result);
    }

    @PostMapping("/confirm")
    public BaseResponse<String> confirmOrder(@RequestBody OrderConfirmReq req, @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException, IamportResponseException, IOException {
        if(customUserDetails==null){
            throw  new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        Long memberIdx = customUserDetails.getIdx();

        String result = orderService.confirmOrder(req, memberIdx);

        return new BaseResponse<>(result);
    }

    //회원이 주문한 상품인지 유무
    @GetMapping("/isOrdered")
    public BaseResponse<isWritableRes> isOrdered(@AuthenticationPrincipal CustomUserDetails customUserDetails, Long productIdx)
            throws BaseException {
        //로그인하지 않은 사용자
        if(customUserDetails==null){
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }

        Long memberIdx = customUserDetails.getIdx();
        isWritableRes isWritable =orderService.isOrdered(memberIdx, productIdx);

        return new BaseResponse<>(isWritable);
    }
}
