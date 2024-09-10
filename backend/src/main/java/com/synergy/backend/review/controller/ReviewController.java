package com.synergy.backend.review.controller;

import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponse;
import com.synergy.backend.common.BaseResponseStatus;
import com.synergy.backend.review.model.request.CreateReviewReq;
import com.synergy.backend.review.model.response.ReadDetailReviewRes;
import com.synergy.backend.review.model.response.ReadListReviewRes;
import com.synergy.backend.review.repository.ReviewRepository;
import com.synergy.backend.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    // 리뷰 작성
    @PostMapping("/create")
    public BaseResponse<Void> create(@RequestBody CreateReviewReq req) throws BaseException {
        Long userIdx = 1L;
        Long productIdx = 1L;
        reviewService.reviewCreate(req, userIdx, productIdx);
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    // 리뷰 리스트 조회
    @GetMapping("/listread")
    public BaseResponse<List<ReadListReviewRes>> listRead(Long productIdx) throws BaseException {
        return new BaseResponse<>(reviewService.reviewListRead(productIdx));
    }

//    // 리뷰 상세 조회
//    @GetMapping("/detailread")
//    public BaseResponse<ReadDetailReviewRes> detailRead(Long reviewIdx) throws BaseException {
//        return new BaseResponse<>(reviewService.reviewDetailRead(reviewIdx));
//    }
}
