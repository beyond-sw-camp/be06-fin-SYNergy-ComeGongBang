package com.synergy.backend.question.service;

import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponse;
import com.synergy.backend.common.BaseResponseStatus;
import com.synergy.backend.product.model.entity.Product;
import com.synergy.backend.product.repository.ProductRepository;
import com.synergy.backend.question.model.entity.Ask;
import com.synergy.backend.question.model.response.AskListRes;
import com.synergy.backend.question.model.response.AskRes;
import com.synergy.backend.question.repository.AskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AskService {
    private final AskRepository askRepository;
    private final ProductRepository productRepository;


    // 문의 목록 조회 서비스 메서드
    public BaseResponse<List<AskRes>> getAskList(Long productId) throws BaseException{
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));

        //askrepository에서 해당 productid로 목록 가져오기
        List<Ask> getAskList = askRepository.findByProductId(productId);

        //요청에 대한 응답형태로 저장하기
        List<AskRes> response = new ArrayList<>();

        for(Ask ask : getAskList){
            response.add(AskRes.builder()
                    .askIdx(ask.getIdx())
                    .content(ask.getContent())
                    .replyContent(ask.getReplyContent())
                    .isSecret(ask.isSecret())

                    .build());
        }
    }

}
