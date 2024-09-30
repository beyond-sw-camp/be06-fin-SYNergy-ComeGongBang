package com.synergy.backend.domain.orders.controller;

import com.synergy.backend.domain.orders.model.request.*;
import com.synergy.backend.domain.orders.model.response.CartRes;
import com.synergy.backend.domain.orders.model.type.CartType;
import com.synergy.backend.domain.orders.service.CartService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    // 새로운 상품 카트에 추가
    @PostMapping
    public BaseResponse<Void> addCart(@RequestBody List<AddCartReq> req,
                                      @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        cartService.addCart(customUserDetails.getIdx(), req);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    // 상품 추가 후 암호화 코드 반환
    @PostMapping("/purchase")
    public BaseResponse<String> addCartForPurchase(@RequestBody List<AddCartReq> req,
                                                   @AuthenticationPrincipal CustomUserDetails customUserDetails) throws Exception {
        String result = cartService.addCartForPurchase(customUserDetails.getIdx(), req);
        return new BaseResponse<>(result);
    }

    //암호화 코드 복호화 후 장바구니 목록 조회
    @GetMapping("/direct/{encrypt}")
    public BaseResponse<CartRes> getCartList(@PathVariable("encrypt") String encrypt,
                                             @AuthenticationPrincipal CustomUserDetails customUserDetails) throws Exception {
        return new BaseResponse<>(cartService.getCartByEncrypt(encrypt, customUserDetails.getIdx()));
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
        return new BaseResponse<>(cartService.getCart(new CartListReq(), customUserDetails.getIdx(), CartType.DEFAULT));
    }

    //장바구니 특정 리스트 조회
    @PostMapping("/direct")
    public BaseResponse<CartRes> getCartList(@RequestBody CartListReq req,
                                             @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return new BaseResponse<>(cartService.getCart(req, customUserDetails.getIdx(),CartType.DIRECT_PURCHASE));
    }


    // 상품 주문 가능한 상태인지 검증
    @PostMapping("/verify")
    public BaseResponse<Void> verifyProduct(@RequestBody VerifyCartReq req) throws BaseException {
        cartService.verifyProduct(req);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    // 요청 메세지 저장
    @PatchMapping("/order-message")
    public BaseResponse<Void> saveOrderMessage(@RequestBody orderMessageReq req,
                                               @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        cartService.saveOrderMessage(req, customUserDetails.getIdx());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }


    // cartIdx 리스트 삭제
    @DeleteMapping
    public BaseResponse<Void> deleteCartList(@RequestBody deleteCartListReq req,
                                             @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        cartService.deleteCartList(req, customUserDetails.getIdx());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    //암호화된 cartIdx 리스트 삭제
    @DeleteMapping("/direct")
    public BaseResponse<Void> deleteCartListDirect(@RequestBody deleteCartListDirectReq req,
                                                   @AuthenticationPrincipal CustomUserDetails customUserDetails) throws Exception {
        cartService.deleteCartListDirect(req, customUserDetails.getIdx());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

}
