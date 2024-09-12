package com.synergy.backend.domain.review.service;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.domain.review.model.entity.Review;
import com.synergy.backend.domain.review.model.request.CreateReviewReq;
import com.synergy.backend.domain.review.model.response.ReadDetailReviewRes;
import com.synergy.backend.domain.review.model.response.ReadListReviewRes;
import com.synergy.backend.domain.review.repository.ReviewRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
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

    // 리뷰 작성
    public void createReview(CreateReviewReq req) throws BaseException {
        Boolean isMember = memberRepository.existsById(req.getMemberIdx());
        Boolean isProduct = productRepository.existsById(req.getProductIdx());
        if (isMember && isProduct) {
            Member member = memberRepository.findById(req.getMemberIdx()).orElseThrow(() ->
                    new BaseException(BaseResponseStatus.NOT_FOUND_USER));
            Product product = productRepository.findById(req.getProductIdx()).orElseThrow(() ->
                    new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));
            Review saved = reviewRepository.save(req.toEntity(member, product));
        }
    }

    // 해당 상품 리뷰 리스트 조회
    public List<ReadListReviewRes> readReviewList(Long productIdx) throws BaseException {
        List<Review> allByProductIdx = reviewRepository.findByProductIdx(productIdx);
        List<ReadListReviewRes> result = new ArrayList<>();

        for (Review review : allByProductIdx) {
            result.add(
                    ReadListReviewRes.builder()
                            .idx(review.getIdx())
                            .nickname(review.getMember().getNickname())
                            .profileImageUrl(review.getMember().getProfileImageUrl())
                            .createdAt(review.getCreatedAt())
                            .content(review.getContent())
                            .score(review.getScore())
                            .build());
        }
        return result;
    }

    // 리뷰 상세 조회
    public ReadDetailReviewRes readReviewDetail(Long reviewIdx) throws BaseException {
        Review review = reviewRepository.findById(reviewIdx)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_REVIEW));

        ReadDetailReviewRes result = ReadDetailReviewRes.builder()
                .reviewIdx(reviewIdx)
                .nickname(review.getMember().getNickname())
                .profileImageUrl(review.getMember().getProfileImageUrl())
                .createdAt(review.getCreatedAt())
                .productName(review.getProduct().getName())
                .thumbnailUrl(review.getProduct().getThumbnailUrl())
                .content(review.getContent())
                .score(review.getScore())
                .build();

        return result;
    }

}
