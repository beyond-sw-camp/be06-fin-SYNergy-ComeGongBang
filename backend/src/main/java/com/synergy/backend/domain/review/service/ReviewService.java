package com.synergy.backend.domain.review.service;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.domain.review.model.entity.Review;
import com.synergy.backend.domain.review.model.request.CreateReviewReq;
import com.synergy.backend.domain.review.repository.ReviewRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    /**
     * 리뷰 작성
     *
     * @param req
     * @param userIdx
     * @param productIdx
     * @return
     * @throws BaseException
     */
    public void reviewCreate(CreateReviewReq req, Long userIdx, Long productIdx) throws BaseException {
        Member member = memberRepository.findById(userIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_USER));
        Product product = productRepository.findById(productIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));
        Review review = reviewRepository.save(req.toEntity(member, product));
    }

}
