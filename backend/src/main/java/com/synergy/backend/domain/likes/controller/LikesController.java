package com.synergy.backend.domain.likes.controller;

import com.synergy.backend.domain.likes.service.LikesService;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.model.response.ProductListRes;
import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/likes")
public class LikesController {

    private final LikesService likesService;
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    //찜하기 기능
    @PostMapping("/toggle")
    public BaseResponse<String> toggleLike(
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @RequestBody Map<String,Long> productIndex) {

        // 현재 로그인한 회원의 ID 가져오기
        Long memberIdx = customUserDetails.getIdx();
        Long productIdx = productIndex.get("productIdx");
        // 찜하기 처리
        likesService.toggleLike(memberIdx, productIdx);
        return new BaseResponse<>("Success");
    }

    // 특정회원이 찜한 상품리스트 가져오기
    @GetMapping("/list")
    public BaseResponse<List<ProductListRes>> getLikedProducts(@AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        // 현재 로그인한 회원 정보 가져오기
        Long memberIdx = customUserDetails.getIdx();
        System.out.println("-----------------------------------------------------------");
        System.out.println("Received memberId: " + memberIdx);
        // 찜한 상품 리스트 가져오기
        List<ProductListRes> likedProductsList = likesService.getLikedProducts(memberIdx);
        System.out.println("-----------------------------------------------------------");
        System.out.println("likedProductsList: " + likedProductsList);
        return new BaseResponse<>(likedProductsList); // 응답 반환

    }
}
