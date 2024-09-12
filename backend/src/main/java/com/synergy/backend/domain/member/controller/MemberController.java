package com.synergy.backend.domain.member.controller;


import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.domain.member.service.MemberService;
import com.synergy.backend.domain.member.model.request.CreateDeliveryAddressReq;
import com.synergy.backend.domain.member.model.request.MemberSignupReq;
import com.synergy.backend.domain.member.model.response.DeliveryAddressRes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody MemberSignupReq memberSignupReq) {
        String result = memberService.signup(memberSignupReq);
        return ResponseEntity.ok(result);
    }

    //    TODO spring security 적용 후 변경
    //     @AuthenticationPrincipal CustomUserDetails customUserDetails,

    //기본 배송지 조회
    @GetMapping("/defaultDeliveryAddress")
    public BaseResponse<DeliveryAddressRes> getDefaultDeliveryAddress(Long userIdx) throws BaseException {
        return new BaseResponse<>(memberService.getDefaultDeliveryAddress(userIdx));
    }


    //배송지 목록 조회 TODO 배송지 없으면 추가할 때 기본 배송지로 설정 ( 체크박스 비활성화 되도록 )
    @GetMapping("/deliveryAddressList")
    public BaseResponse<List<DeliveryAddressRes>> getDeliveryAddress(Long userIdx) throws BaseException {
        return new BaseResponse<>(memberService.getDeliveryAddressList(userIdx));
    }


    //배송지 추가 TODO 배송지 없으면 기본 배송지로 설정하는 거
    @PostMapping("/deliveryAddress")
    public BaseResponse<Void> createDeliveryAddress(@RequestBody CreateDeliveryAddressReq req) throws BaseException {
        Long userIdx = 1L;
        memberService.createDeliveryAddress(req, userIdx);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }
}
