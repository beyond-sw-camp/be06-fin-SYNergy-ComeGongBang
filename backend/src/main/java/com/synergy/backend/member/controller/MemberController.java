package com.synergy.backend.member.controller;

import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponse;
import com.synergy.backend.common.BaseResponseStatus;
import com.synergy.backend.member.model.request.CreateDeliveryAddressReq;
import com.synergy.backend.member.model.response.DeliveryAddressRes;
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

    //기본 배송지 조회
    @GetMapping("/defaultDeliveryAddress")
    public BaseResponse<DeliveryAddressRes> getDefaultDeliveryAddress(Long userIdx) throws BaseException {
        return new BaseResponse<>(memberService.getDefaultDeliveryAddress(userIdx));
    }


    //배송지 목록 조회
    @GetMapping("/deliveryAddressList")
    public BaseResponse<List<DeliveryAddressRes>> getDeliveryAddress(Long userIdx) throws BaseException {
        return new BaseResponse<>(memberService.getDeliveryAddressList(userIdx));
    }


    //배송지 추가
    @PostMapping("/deliveryAddress")
    public BaseResponse<Void> createDeliveryAddress(@RequestBody CreateDeliveryAddressReq req, Long userIdx) throws BaseException {
        memberService.createDeliveryAddress(req, userIdx);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
}
