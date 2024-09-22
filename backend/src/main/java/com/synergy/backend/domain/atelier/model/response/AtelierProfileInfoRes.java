package com.synergy.backend.domain.atelier.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AtelierProfileInfoRes {

    // 공방 idx
    private Long atelierIdx;
    // 공방 프로필 이미지
    private String atelierProfileImage;
    // 공방 이름
    private String atelierName;
    // 공방 평점
    private double atelierAverageScore;
    //공방 상품 리뷰 개수
    private int havingProductsReviewCount;
    // 공방이 파는 모든상품 찜 수
    private int havingProductsLikeCount;
    // 공방 팔로워 수
    private int havingFollowerCount;
    // 공방 한줄 소개글
    private String oneLineDescription;
    // 회원-공방 팔로우 여부
    private boolean memberIsFollow;

}
