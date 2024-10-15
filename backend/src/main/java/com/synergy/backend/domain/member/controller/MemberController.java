package com.synergy.backend.domain.member.controller;


import com.synergy.backend.domain.member.model.request.CreateDeliveryAddressReq;
import com.synergy.backend.domain.member.model.request.IsMemberReq;
import com.synergy.backend.domain.member.model.request.MemberSignupReq;
import com.synergy.backend.domain.member.model.request.MemberUpdateReq;
import com.synergy.backend.domain.member.model.response.DeliveryAddressRes;
import com.synergy.backend.domain.member.model.response.MemberInfoRes;
import com.synergy.backend.domain.member.model.response.MemberPaymentRes;
import com.synergy.backend.domain.member.service.MemberService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetailService;
import com.synergy.backend.global.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final CustomUserDetailService customUserDetailService;

    @GetMapping("/isLogined")
    public BaseResponse<Long> isLogined(@AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        Long memberIdx = memberService.isLogined(customUserDetails);
        return new BaseResponse<>(memberIdx);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody MemberSignupReq memberSignupReq) {
        String result = memberService.signup(memberSignupReq);
        return ResponseEntity.ok(result);
    }

    //기본 배송지 조회
    @GetMapping("/defaultDeliveryAddress")
    public BaseResponse<DeliveryAddressRes> getDefaultDeliveryAddress(
            @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        return new BaseResponse<>(memberService.getDefaultDeliveryAddress(customUserDetails.getIdx()));
    }


    //배송지 목록 조회
    @GetMapping("/deliveryAddressList")
    public BaseResponse<List<DeliveryAddressRes>> getDeliveryAddress(
            @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        return new BaseResponse<>(memberService.getDeliveryAddressList(customUserDetails.getIdx()));
    }

    //배송지 추가
    @PostMapping("/deliveryAddress")
    public BaseResponse<Void> createDeliveryAddress(@RequestBody CreateDeliveryAddressReq req,
                                                    @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        memberService.createDeliveryAddress(req, customUserDetails.getIdx());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    //배송지 삭제
    @DeleteMapping("/delivery/{deliveryIdx}")
    public BaseResponse<Void> deleteDelivery(@PathVariable Long deliveryIdx,
                                             @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        if (customUserDetails == null){
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        memberService.deleteDelivery(deliveryIdx,customUserDetails.getIdx());
        return new BaseResponse<>(BaseResponseStatus.DELETE_ADDRESS);
    }

    @GetMapping("/login")
    public BaseResponse<MemberInfoRes> getMemberInfo(@AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        Long memberIdx = customUserDetails.getIdx();
        MemberInfoRes memberInfo = memberService.getMemberInfo(memberIdx);

        return new BaseResponse<>(memberInfo);
    }

    @PutMapping("/info")
    public BaseResponse<MemberInfoRes> updateMemberInfo(@RequestBody MemberUpdateReq req,
                                                        @AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        System.out.println(req.getNickname());
        Long memberIdx = customUserDetails.getIdx();
        return new BaseResponse<>(memberService.updateMemberInfo(memberIdx, req));

    }

    @GetMapping("/payment/info")
    public BaseResponse<MemberPaymentRes> getMemberPaymentInfo(@AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        if(customUserDetails==null){
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        return new BaseResponse<>(memberService.getMemberPaymentInfo(customUserDetails.getIdx()));
    }

    @PostMapping
    public BaseResponse<Boolean> isMember(IsMemberReq req){
        Boolean result = memberService.isMember(req.getMemberEmail());
        return new BaseResponse<>(result);
    }

    @DeleteMapping()
    public BaseResponse<String> deleteMember(@AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        if (customUserDetails == null){
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        Long memberIdx = customUserDetails.getIdx();

        String response = memberService.deleteMember(memberIdx);
        return new BaseResponse<>(response);
    }
}

