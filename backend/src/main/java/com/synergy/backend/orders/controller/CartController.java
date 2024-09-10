package com.synergy.backend.orders.controller;

import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponse;
import com.synergy.backend.common.BaseResponseStatus;
import com.synergy.backend.global.security.CustomUserDetails;
import com.synergy.backend.orders.model.request.AddCartReq;
import com.synergy.backend.orders.model.request.IncreaseProductReq;
import com.synergy.backend.orders.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // 새로운 상품 카트에 추가
    @PostMapping
    public BaseResponse<Void> addCart(@RequestBody AddCartReq req,
                                      @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        cartService.addCart(customUserDetails.getIdx(), req);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    // 중복 상품일 때 상품 수량 증가
    @PostMapping("/increase")
    public BaseResponse<Void> increase(@RequestBody IncreaseProductReq req,
                                       @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        cartService.increase(req.getCartIdx());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    //상품 수량 감소
    @PostMapping("/decrease")
    public BaseResponse<Void> decrease(@RequestBody IncreaseProductReq req,
                                       @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        cartService.decrease(req.getCartIdx());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    // 상품 목록 조회



    // 상품 검증


    // 선택 상품 주문은 pinia를 통해
}
