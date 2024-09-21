package com.synergy.backend.global.common;

import lombok.Getter;

/**
 * 에러 코드 관리
 */
@Getter
public enum BaseResponseStatus {

    /**
     * 필터 단계에서 확인되는 에러는 실제 에러코드 형태여야 함.
     */
    FAIL(false, 400, "요청 실패"),
    EXPIRED_TOKEN(false, 500, "만료된 토큰 입니다."),


    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),


    /**
     * 2000: 유저, 등급, 팔로우
     */
    NOT_FOUND_USER(false, 2000, "유저를 찾을 수 없습니다."),
    REQUIRED_VALUE_NOT_ENTERED(false, 2001, "필수값이 모두 입력되지 않았습니다."),
    NOT_FOUND_GRADE(false,2002,"등급이 존재하지 않습니다."),


    /**
     * 3000: 상품, 카테고리
     */

    NOT_FOUND_PRODUCT(false, 3000, "상품을 찾을 수 없습니다."),
    NOT_FOUND_PRODUCT_MAJOR_OPTIONS(false, 3001, "상품 대분류 옵션을 찾을 수 없습니다."),
    NOT_FOUND_PRODUCT_SUB_OPTIONS(false, 3002, "상품 소분류 옵션을 찾을 수 없습니다."),
    OUT_OF_STOCK(false, 3003, "재고가 없습니다."),
    /**
     * 4000: 주문, 결제
     */
    NOT_FOUND_CART(false, 4000, "장바구니가 존재하지 않습니다."),
    COUNT_BELOW_ZERO(false, 4001, "수량은 0개가 될 수 없습니다."),
    EXCEEDS_MAX_COUNT(false, 4002, "지정된 수량 이상 선택할 수 없습니다."),


    /**
     * 5000: QNA, 리뷰
     */
    NOT_FOUND_REVIEW(false, 5000, "리뷰가 존재하지 않습니다."),



    /**
     * 6000: 작가
     */
    NOT_FOUND_ATELIER(false,6000 ,"작가를 찾을 수 없습니다." ),

    /**
     * 7000: 문의
     */
    NOT_FOUND_ASK(false, 7000, "문의 댓글을 찾을 수 없습니다."),
    DUPLICATED_ASK(false, 7001, "중복 댓글입니다."),
    ALREADY_UPLOAD_ASK(false, 7002, "이미 등록한 댓글입니다.");
//    NOT_FOUND_ASK(false, 7000, "문의댓글을 찾을 수 없습니다."),



    /**
     * 7000: 공통 에러
     */

    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
