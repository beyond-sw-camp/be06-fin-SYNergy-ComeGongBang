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
     * @param req
     * @throws BaseException
     */
    public void reviewCreate(CreateReviewReq req) throws BaseException {
        Boolean member = memberRepository.existsById(req.getMemberIdx());
        Boolean product = productRepository.existsById(req.getProductIdx());
        if (member && product) {
            Member member1 = memberRepository.findById(req.getMemberIdx()).orElseThrow(() ->
                    new BaseException(BaseResponseStatus.NOT_FOUND_USER));
            Product product1 = productRepository.findById(req.getProductIdx()).orElseThrow(() ->
                    new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));
            Review saved = reviewRepository.save(req.toEntity(member1, product1));
        }
    }

}
