package com.synergy.backend.question.controller;

import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponse;
import com.synergy.backend.question.model.response.AskListRes;
import com.synergy.backend.question.service.AskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asks")
@RequiredArgsConstructor
public class AskController {
    private final AskService askService;

    //문의댓글조회
    @GetMapping("/list/read")
    public BaseResponse<List<AskListRes>> getAskList(Integer page, Integer size, Long productIdx) throws BaseException {
        List<AskListRes> result = askService.read(page, size, productIdx);
        return new BaseResponse<>(result);
    }
}
