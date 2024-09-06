package com.synergy.backend.member.controller;

import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponse;
import com.synergy.backend.common.BaseResponseStatus;
import com.synergy.backend.member.model.request.createDeliveryAddressReq;
import com.synergy.backend.member.model.response.deliveryAddressRes;
import com.synergy.backend.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    //    TODO spring security 적용 후 변경
    //     @AuthenticationPrincipal CustomUserDetails customUserDetails,
    //     글로벌 예외처리도

    //기본 배송지 조회
    @GetMapping("/defaultDeliveryAddress")
    public BaseResponse<deliveryAddressRes> getDefaultDeliveryAddress() throws BaseException {
        Long userIdx = 1L;
        return new BaseResponse<>(memberService.getDefaultDeliveryAddress(userIdx));
    }


    //배송지 목록 조회
    @GetMapping("/deliveryAddressList")
    public BaseResponse<List<deliveryAddressRes>> getDeliveryAddress() throws BaseException {
        Long userIdx = 1L;
        return new BaseResponse<>(memberService.getDeliveryAddressList(userIdx));
    }


    //배송지 추가
    @PostMapping("/deliveryAddress")
    public BaseResponse<Void> createDeliveryAddress(@RequestBody createDeliveryAddressReq req) throws BaseException {
        Long userIdx = 1L;
        memberService.createDeliveryAddress(req, userIdx);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
}
