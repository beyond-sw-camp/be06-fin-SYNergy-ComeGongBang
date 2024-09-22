package com.synergy.backend.domain.orders.controller;

import com.fasterxml.jackson.databind.ser.Serializers.Base;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.orders.model.response.PresentRes;
import com.synergy.backend.domain.orders.service.PresentService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/present")
@RequiredArgsConstructor
public class PresentController {
    private final PresentService presentService;

    @GetMapping("/give")
    public BaseResponse<List<PresentRes>> giveList(@AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        //로그인을 안했을 경우
        if(customUserDetails==null){
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }

        Long memberIdx = customUserDetails.getIdx();
        List<PresentRes> responses = presentService.giveList(memberIdx);
        return new BaseResponse<>(responses);
    }

    @GetMapping("/take")
    public BaseResponse<List<PresentRes>> takeList(@AuthenticationPrincipal CustomUserDetails customUserDetails)
            throws BaseException {
        //로그인을 안했을 경우
        if(customUserDetails==null){
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }

        Long memberIdx = customUserDetails.getIdx();
        List<PresentRes> responses = presentService.takeList(memberIdx);
        return new BaseResponse<>(responses);
    }

}
