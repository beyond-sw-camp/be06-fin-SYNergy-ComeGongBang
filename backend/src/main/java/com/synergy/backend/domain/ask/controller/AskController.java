package com.synergy.backend.domain.ask.controller;

import com.synergy.backend.domain.ask.model.request.AskReq;
import com.synergy.backend.domain.ask.model.response.AskRes;
import com.synergy.backend.domain.ask.service.AskService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ask")
@RequiredArgsConstructor
public class AskController {
    private final AskService askService;

    // 문의 생성 API
    @PostMapping("/create")
    public BaseResponse<AskRes> createAsk(@RequestBody AskReq askReq, @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException{
        System.out.println(askReq.getProductIdx());
        System.out.println(askReq.getIsSecret());
        System.out.println(askReq.getContent());

        AskRes response = askService.createAsks(askReq,customUserDetails.getIdx());
        return new BaseResponse<>(response);  // BaseResponse만 반환
   }

    // 문의 조회 API
    @GetMapping("/list/read")
    public BaseResponse<List<AskRes>> getAsksList(@RequestParam Long productIdx,Integer page, Integer size) throws BaseException {
        List<AskRes> askResList = askService.getAskListByProduct(productIdx, page, size);
        return new BaseResponse<>(askResList);  // BaseResponse만 반환
    }
}



