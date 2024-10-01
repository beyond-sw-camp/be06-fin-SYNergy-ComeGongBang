package com.synergy.backend.domain.likes.controller;

import com.synergy.backend.domain.likes.model.response.LikesInfoResponse;
import com.synergy.backend.domain.likes.service.LikesService;
import com.synergy.backend.domain.product.model.response.ProductListRes;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/likes")
public class LikesController {

    private final LikesService likesService;

    //찜하기 기능
    @PostMapping("/toggle")
    public BaseResponse<LikesInfoResponse> toggleLike(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @RequestBody Map<String, Long> productIndex) throws BaseException {

        if(customUserDetails==null){
            throw new BaseException(BaseResponseStatus.NEED_TO_LOGIN);
        }
        // 현재 로그인한 회원의 ID 가져오기
        Long memberIdx = customUserDetails.getIdx();
        Long productIdx = productIndex.get("productIdx");
        // 찜하기 처리
        LikesInfoResponse result = likesService.toggleLike(memberIdx, productIdx);
        return new BaseResponse<>(result);
    }

    // 특정회원이 찜한 상품리스트 가져오기
    @GetMapping("/list")
    public BaseResponse<List<ProductListRes>> getLikedProducts(
            @AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        // 현재 로그인한 회원 정보 가져오기
        if(customUserDetails==null){
            return new BaseResponse<>(new ArrayList<>());
        }
        Long memberIdx = customUserDetails.getIdx();
        // 찜한 상품 리스트 가져오기
        List<ProductListRes> likedProductsList = likesService.getLikedProducts(memberIdx);
        return new BaseResponse<>(likedProductsList); // 응답 반환

    }
}
