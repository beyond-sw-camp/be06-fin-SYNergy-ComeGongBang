package com.synergy.backend.question.controller;

import com.synergy.backend.common.BaseResponse;
import com.synergy.backend.question.model.request.AskReq;
import com.synergy.backend.question.model.request.ReplyReq;
import com.synergy.backend.question.model.response.AskRes;
import com.synergy.backend.question.model.response.ReplyRes;
import com.synergy.backend.question.service.AskService;
import com.synergy.backend.question.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



