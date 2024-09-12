package com.synergy.backend.question.service;

import com.synergy.backend.atelier.model.entity.Atelier;
import com.synergy.backend.atelier.repository.AtelierRepository;
import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponse;
import com.synergy.backend.common.BaseResponseStatus;
import com.synergy.backend.product.model.entity.Product;
import com.synergy.backend.product.repository.ProductRepository;
import com.synergy.backend.question.model.entity.Ask;
import com.synergy.backend.question.model.entity.Reply;
import com.synergy.backend.question.model.request.ReplyReq;
import com.synergy.backend.question.model.response.AskRes;
import com.synergy.backend.question.model.response.ReplyRes;
import com.synergy.backend.question.repository.AskRepository;
import com.synergy.backend.question.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final AtelierRepository atelierRepository;
    private final AskRepository askRepository;
    private final ProductRepository productRepository;
    private final ReplyRepository replyRepository;

    //답글생성
    public ReplyRes createReply(ReplyReq replyReq) {
        Ask ask = askRepository.findById(replyReq.getAskIdx())
                .orElseThrow(() -> new IllegalArgumentException("해당 문의를 찾을 수 없습니다."));
        Atelier atelier = atelierRepository.findById(replyReq.getReplyAtelierIdx())
                .orElseThrow(() -> new IllegalArgumentException("해당 공방을 찾을 수 없습니다."));

        // Reply 객체 생성 하기
         Reply reply = Reply.builder()
                .idx(replyReq.getReplyAtelierIdx())
                .replyname(replyReq.getReplyAtelierName())
                .replyContent(replyReq.getReplyContent())
                .build();

         //만든거 저장하기
        replyRepository.save(reply);

        //dto로 변환하기
        return ReplyRes.builder()
                .replyAtelierIdx(reply.getAtelier().getIdx())
                .replyAteliername(reply.getReplyname())
                .replyAtelierProfileImageUrl(reply.getAtelier().getProfileImage())
                .replyContent(reply.getReplyContent())
                .build();
    }

}
