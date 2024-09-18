package com.synergy.backend.domain.ask.controller;

import com.synergy.backend.domain.ask.model.request.ReplyReq;
import com.synergy.backend.domain.ask.model.response.ReplyRes;
import com.synergy.backend.domain.ask.service.ReplyService;
import com.synergy.backend.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    // 댓글 생성 API
    @PostMapping("/create")
    public BaseResponse<ReplyRes> createReply(@RequestBody ReplyReq replyReq) {
        ReplyRes response = replyService.createReply(replyReq);
        return new BaseResponse<>(response);  // BaseResponse만 반환
    }
}



