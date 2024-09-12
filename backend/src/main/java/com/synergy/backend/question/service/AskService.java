package com.synergy.backend.question.service;

import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponse;
import com.synergy.backend.common.BaseResponseStatus;
import com.synergy.backend.member.model.entity.Member;
import com.synergy.backend.member.repository.MemberRepository;
import com.synergy.backend.product.model.entity.Product;
import com.synergy.backend.product.repository.ProductRepository;
import com.synergy.backend.question.model.entity.Ask;
import com.synergy.backend.question.model.entity.Reply;

import com.synergy.backend.question.model.request.AskReq;
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
public class AskService {
    private final AskRepository askRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final ReplyRepository replyRepository;

    //문의 생성
    public AskRes createAsks(AskReq askReq) {
        // 회원 조회
        Member member = memberRepository.findById(askReq.getMemberIdx())
                .orElseThrow(() -> new IllegalArgumentException("해당 회원을 찾을 수 없습니다."));
        // 상품 조회
        Product product = productRepository.findById(askReq.getProductIdx())
                .orElseThrow(() -> new IllegalArgumentException("해당 상품을 찾을 수 없습니다."));

        // @Builder를 사용하여 Ask 객체 생성
        Ask ask = Ask.builder()
                .member(member)
                .product(product)
                .content(askReq.getContent())
                .isSecret(askReq.isSecret())
                .build();

        askRepository.save(ask);

        // DTO로 변환하여 BaseResponse로 반환
        AskRes askRes = new AskRes(
                ask.getMember().getIdx(),
                ask.getMember().getNickname(),
                ask.getMember().getProfileImageUrl(),
                ask.getContent(),
                ask.getIdx(),
                ask.isSecret(),
                null // 생성 시에는 Reply가 아직 없음
        );

        return askRes;  // 성공 시 응답
    }


    // 해당 상품 문의 목록 조회 서비스 메서드
    public List<AskRes> getAskListByProduct(Long productIdx) throws BaseException{
        //상품조회
        Product product = productRepository.findById(productIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));

        //askrepository에서 해당 productid로 목록 가져오기
        List<Ask> getAskList = askRepository.findByProductIdx(productIdx);

        //결과담을곳
        List<AskRes> result = new ArrayList<>();

        //리스트니까 반복문돌리기
        for(Ask ask : getAskList){
            //답글가져오기
            Reply reply = ask.getReply();
            //답글없을경우 처리
            ReplyRes replyRes = null;

            //답글이있으면
            if(reply != null){
                replyRes = ReplyRes.builder()
                        .replyAtelierIdx(reply.getAtelier().getIdx())
                        .replyAteliername(reply.getAtelier().getName())
                        .replyAtelierProfileImageUrl(reply.getAtelier().getProfileImage())
                        .replyContent(reply.getReplyContent())
                        .build();
            }

            AskRes askRes = AskRes.builder()
                    .memberIdx(ask.getMember().getIdx())
                    .username(ask.getUsername())
                    .profileImageUrl(ask.getProfileImageUrl())
                    .content(ask.getContent())
                    .isSecret(ask.isSecret())
                    .reply(replyRes)  // 답변 추가
                    .build();

            result.add(askRes);
        }
        return result;
    }

}
