package com.synergy.backend.domain.ask.service;

import com.synergy.backend.domain.product.model.dto.response.SearchProductRes;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.domain.ask.model.entity.Ask;
import com.synergy.backend.domain.ask.model.request.AskReq;
import com.synergy.backend.domain.ask.model.response.ReplyRes;
import com.synergy.backend.domain.ask.repository.AskRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.domain.ask.model.entity.Reply;

import com.synergy.backend.domain.ask.model.response.AskRes;
import com.synergy.backend.domain.ask.repository.ReplyRepository;
import com.synergy.backend.global.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.synergy.backend.domain.ask.model.entity.QReply.reply;

@Service
@RequiredArgsConstructor
public class AskService {
    private final AskRepository askRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final ReplyRepository replyRepository;

    //문의 생성
    public AskRes createAsks(AskReq askReq, Long idx) throws BaseException {
        // 회원 조회
        Member member = memberRepository.findById(idx)
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
        AskRes askRes = AskRes.builder()
                .memberIdx(ask.getMember().getIdx())
                .username(ask.getMember().getNickname())
                .profileImageUrl(ask.getMember().getProfileImageUrl())
                .content(ask.getContent())
                .isSecret(ask.isSecret())
                .reply(null)  // 답변 추가
                .build();
        return askRes;  // 성공 시 응답
    }


    // 해당 상품 문의 목록 조회 서비스 메서드
    public List<AskRes> getAskListByProduct(Long productIdx, Integer page, Integer size) throws BaseException{
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "idx"));

        //해당상품이 있는지 없는지
        Product product = productRepository.findById(productIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));

        //askrepository에서 해당 productid로 목록 가져오기
        List<Ask> getAskList = askRepository.findByProductIdx(productIdx, pageable);

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
                    .username(ask.getMember().getNickname())
                    .profileImageUrl(ask.getMember().getProfileImageUrl())
                    .content(ask.getContent())
                    .isSecret(ask.isSecret())
                    .reply(replyRes)  // 답변 추가
                    .build();

            result.add(askRes);
        }
        return result;
    }

}
