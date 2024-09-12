package com.synergy.backend.domain.ask.controller;

import com.synergy.backend.domain.ask.model.request.AskReq;
import com.synergy.backend.domain.ask.model.response.AskRes;
import com.synergy.backend.domain.ask.service.AskService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ask")
@RequiredArgsConstructor
public class AskController {
    private final AskService askService;

    // 문의 생성 API
    @PostMapping("/create")
    public BaseResponse<AskRes> createAsk(@RequestBody AskReq askReq) {
        AskRes response = askService.createAsks(askReq);
        return new BaseResponse<>(response);  // BaseResponse만 반환
    }

    // 문의 조회 API
    @GetMapping("/list")
    public BaseResponse<List<AskRes>> getAsksList(@RequestParam Long productIdx) throws BaseException {
        List<AskRes> askResList = askService.getAskListByProduct(productIdx);
        return new BaseResponse<>(askResList);  // BaseResponse만 반환
    }
}



