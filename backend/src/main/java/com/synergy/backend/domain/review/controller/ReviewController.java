package com.synergy.backend.domain.review.controller;

import com.synergy.backend.domain.review.model.request.CreateReviewReq;
import com.synergy.backend.domain.review.model.response.MyReviewListRes;
import com.synergy.backend.domain.review.model.response.ReadDetailReviewRes;
import com.synergy.backend.domain.review.model.response.ReviewListResponse;
import com.synergy.backend.domain.review.model.response.WritableReviewRes;
import com.synergy.backend.domain.review.service.ReviewService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {
    private final ReviewService reviewService;

    // 리뷰 작성
    @PostMapping
    public BaseResponse<Void> create(@RequestBody CreateReviewReq req,
                                     @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        reviewService.createReview(req, customUserDetails.getIdx());
        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    // 상품의 리뷰 리스트 조회
    @GetMapping("/{productIdx}")
    public BaseResponse<ReviewListResponse> getReviewList(@PathVariable Long productIdx,
                                                          @RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size) throws BaseException {
        return new BaseResponse<>(reviewService.readReviewList(productIdx, page, size));
    }

    // 리뷰 상세 조회
    @GetMapping("/{reviewIdx}/detail")
    public BaseResponse<ReadDetailReviewRes> getReviewDetail(@PathVariable Long reviewIdx) throws BaseException {
        return new BaseResponse<>(reviewService.readReviewDetail(reviewIdx));
    }

    //내가 작성한 리뷰 조회
    @GetMapping("/me")
    public BaseResponse<Page<MyReviewListRes>> getMyReviewList(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                                               @RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "10") int size) throws BaseException {
        if(customUserDetails==null){
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        return new BaseResponse<>(reviewService.getMyReviewList(customUserDetails.getIdx(), page, size));
    }

    //작성 가능한 후기
    @GetMapping("/writable")
    public BaseResponse<List<WritableReviewRes>> getWritableReviewList(@AuthenticationPrincipal CustomUserDetails customUserDetails, int page, int size)
            throws BaseException {
        if(customUserDetails==null){
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        Long memberIdx = customUserDetails.getIdx();
        List<WritableReviewRes> responses = reviewService.getWritableReviewList(memberIdx, page, size);
        return new BaseResponse<>(responses);
    }

}
