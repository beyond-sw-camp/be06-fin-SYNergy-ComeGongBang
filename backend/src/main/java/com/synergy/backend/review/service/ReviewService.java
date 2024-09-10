package com.synergy.backend.review.service;

import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponseStatus;
import com.synergy.backend.member.model.entity.DeliveryAddress;
import com.synergy.backend.member.model.entity.Member;
import com.synergy.backend.member.repository.MemberRepository;
import com.synergy.backend.product.model.entity.Product;
import com.synergy.backend.product.repository.ProductRepository;
import com.synergy.backend.review.model.entity.Review;
import com.synergy.backend.review.model.request.CreateReviewReq;
import com.synergy.backend.review.model.response.CreateReviewRes;
import com.synergy.backend.review.model.response.ReadDetailReviewRes;
import com.synergy.backend.review.model.response.ReadListReviewRes;
import com.synergy.backend.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<ReadListReviewRes> reviewListRead(Long productIdx) throws BaseException {
        List<Review> allByProductIdx = reviewRepository.getAllByProductIdx(productIdx);
        List<ReadListReviewRes> result = new ArrayList<>();

        for (Review review : allByProductIdx) {
            result.add(ReadListReviewRes.builder()
                    .idx(review.getIdx())
                    .member(review.getMember())
                    .product(review.getProduct())
                    .content(review.getContent())
                    .score(review.getScore())
                    .build());
        }
        return result;
    }

//    public ReadDetailReviewRes reviewDetailRead(Long reviewIdx) throws BaseException {
//        Review reviewByReviewIdx = reviewRepository.getById(reviewIdx);
//        ReadDetailReviewRes result;
//        return result;
//    }

}
