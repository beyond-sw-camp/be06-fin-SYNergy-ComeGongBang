package com.synergy.backend.domain.member.controller;


import com.synergy.backend.domain.member.model.request.CreateDeliveryAddressReq;
import com.synergy.backend.domain.member.model.request.IsMemberReq;
import com.synergy.backend.domain.member.model.request.MemberSignupReq;
import com.synergy.backend.domain.member.model.request.MemberUpdateReq;
import com.synergy.backend.domain.member.model.response.DeliveryAddressRes;
import com.synergy.backend.domain.member.model.response.MemberInfoRes;
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


    //배송지 목록 조회 TODO 배송지 없으면 추가할 때 기본 배송지로 설정 ( 체크박스 비활성화 되도록 )
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

    @DeleteMapping("/delivery/{idx}")
    public BaseResponse<Void> deleteDelivery(@PathVariable Long idx,
                                             @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        if (customUserDetails == null){
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa"+idx);
        memberService.deleteDelivery(idx, customUserDetails.getIdx());

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

    @PostMapping
    public BaseResponse<Boolean> isMember(IsMemberReq req){
        Boolean result = memberService.isMember(req.getMemberEmail());
        return new BaseResponse<>(result);
    }
}
