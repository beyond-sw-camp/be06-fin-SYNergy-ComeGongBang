package com.synergy.backend.domain.orders.controller;

import com.synergy.backend.domain.orders.model.request.AddCartReq;
import com.synergy.backend.domain.orders.model.request.UpdateCartCountReq;
import com.synergy.backend.domain.orders.model.request.VerifyCartReq;
import com.synergy.backend.domain.orders.model.response.CartRes;
import com.synergy.backend.domain.orders.service.CartService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
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

    // 상품 수량 업데이트
    @PostMapping("/updateCount")
    public BaseResponse<Void> increase(@RequestBody UpdateCartCountReq req,
                                       @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        Long userIdx = 1L;
        cartService.updateCount(req);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }


    // 장바구니 목록 조회
    @GetMapping
    public BaseResponse<CartRes> getCarts(@RequestParam Long userIdx) {
//        Long userIdx = customUserDetails.getIdx();
        return new BaseResponse<>(cartService.getCart(userIdx));
    }


    // 상품 주문 가능한 상태인지 검증
    @PostMapping("/verify")
    public BaseResponse<Void> verifyProduct(@RequestBody VerifyCartReq req) throws BaseException {
        cartService.verifyProduct(req);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }


    // 선택 상품 주문은 pinia를 통해
}
