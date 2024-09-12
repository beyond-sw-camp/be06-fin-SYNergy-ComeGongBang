package com.synergy.backend.question.controller;

import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponse;
import com.synergy.backend.question.model.request.AskReq;
import com.synergy.backend.question.model.response.AskRes;
import com.synergy.backend.question.service.AskService;
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



