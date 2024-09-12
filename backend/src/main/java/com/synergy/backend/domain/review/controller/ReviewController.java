package com.synergy.backend.domain.review.controller;

import com.synergy.backend.domain.review.model.request.CreateReviewReq;
import com.synergy.backend.domain.review.model.response.ReadDetailReviewRes;
import com.synergy.backend.domain.review.model.response.ReadListReviewRes;
import com.synergy.backend.domain.review.service.ReviewService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    // 리뷰 작성
    @PostMapping
    public BaseResponse<Void> create(@RequestBody CreateReviewReq req) throws BaseException {
        reviewService.createReview(req);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    // 리뷰 리스트 조회
    @GetMapping
    public BaseResponse<List<ReadListReviewRes>> list(Long productIdx) throws BaseException {
        return new BaseResponse<>(reviewService.readReviewList(productIdx));
    }

    // 리뷰 상세 조회
    @GetMapping("/detail")
    public BaseResponse<ReadDetailReviewRes> detail(Long reviewIdx) throws BaseException {
        return new BaseResponse<>(reviewService.readReviewDetail(reviewIdx));
    }

}
