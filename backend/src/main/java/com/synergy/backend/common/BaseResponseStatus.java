package com.synergy.backend.common;

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
    REQUIRED_VALUE_NOT_ENTERED(false, 2001, "필수값이 모두 입력되지 않았습니다.");


    /**
     * 3000: 상품, 카테고리
     */


    /**
     * 4000: 주문, 결제
     */


    /**
     * 5000: QNA, 리뷰
     */


    /**
     * 6000: 작가
     */


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
