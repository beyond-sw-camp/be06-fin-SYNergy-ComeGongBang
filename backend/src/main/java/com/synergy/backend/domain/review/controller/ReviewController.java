package com.synergy.backend.domain.review.controller;

import com.synergy.backend.domain.review.model.request.CreateReviewReq;
import com.synergy.backend.domain.review.service.ReviewService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    // 리뷰 작성
    @PostMapping
    public BaseResponse<Void> create(@RequestBody CreateReviewReq req) throws BaseException {
        reviewService.reviewCreate(req);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

}
