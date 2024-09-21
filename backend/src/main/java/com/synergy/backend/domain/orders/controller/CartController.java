package com.synergy.backend.domain.orders.controller;

import com.synergy.backend.domain.orders.model.request.*;
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
    public BaseResponse<CartRes> getCarts(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return new BaseResponse<>(cartService.getCart(new CartListReq(), customUserDetails.getIdx()));
    }
    //TODO cartIdx 가 아니라 productIDx를 리스트로 받음.

    /**
     * 장바구니 목록 조회 memberIdx로 조회
     * 장바구니 특정 상품 cartIdx 리스트 조회
     * 장바구니에서 productIdx를 누르면 그 상품의 cartIdx 리스트를 보내주자
     */
    //장바구니 특정 리스트 조회
    @PostMapping("/direct")
    public BaseResponse<CartRes> getCartList(@RequestBody CartListReq req,
                                             @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return new BaseResponse<>(cartService.getCart(req, customUserDetails.getIdx()));
    }


    // 상품 주문 가능한 상태인지 검증
    @PostMapping("/verify")
    public BaseResponse<Void> verifyProduct(@RequestBody VerifyCartReq req) throws BaseException {
        cartService.verifyProduct(req);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @PostMapping("/order-message")
    public BaseResponse<Void> saveOrderMessage(@RequestBody orderMessageReq req,
                                               @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        cartService.saveOrderMessage(req, customUserDetails.getIdx());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);

    }


}
