package com.synergy.backend.domain.ask.service;

import com.synergy.backend.domain.ask.model.entity.Ask;
import com.synergy.backend.domain.ask.model.entity.Reply;
import com.synergy.backend.domain.ask.model.request.ReplyReq;
import com.synergy.backend.domain.ask.model.response.ReplyRes;
import com.synergy.backend.domain.ask.repository.AskRepository;
import com.synergy.backend.domain.ask.repository.ReplyRepository;
import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.atelier.respository.AtelierRepository;
import com.synergy.backend.domain.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
                .atelier(atelier)
                .ask(ask)
                 .replyContent(replyReq.getReplyContent())
                .build();

         //만든거 저장하기
        replyRepository.save(reply);

        //dto로 변환하기
        return ReplyRes.builder()
                .replyAtelierIdx(reply.getAtelier().getIdx())
                .replyAteliername(reply.getAtelier().getName())
                .replyAtelierProfileImageUrl(reply.getAtelier().getProfileImage())
                .replyContent(reply.getReplyContent())
                .build();
    }

}
