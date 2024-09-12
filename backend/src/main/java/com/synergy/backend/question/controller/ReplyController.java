package com.synergy.backend.question.controller;

import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponse;
import com.synergy.backend.question.model.request.AskReq;
import com.synergy.backend.question.model.response.AskListRes;
import com.synergy.backend.question.model.response.AskRes;
import com.synergy.backend.question.service.AskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asks")
@RequiredArgsConstructor
public class AskController {
    private final AskService askService;

    // 문의 생성 API
    @PostMapping("/create")
    public BaseResponse<AskRes> createAsk(@RequestBody AskReq askRequestDTO) {
        AskRes response = askService.createAsk(askRequestDTO);
        return new BaseResponse<>(response);  // BaseResponse만 반환
    }

    // 문의 조회 API
    @GetMapping("/list/read?idx={productIdx}")
    public BaseResponse<List<AskRes>> getAskList(@PathVariable Long productIdx) {
        List<AskRes> askResponseDTOList = askService.getAskListByProductId(productIdx);
        return new BaseResponse<>(askResponseDTOList);  // BaseResponse만 반환
    }
}



