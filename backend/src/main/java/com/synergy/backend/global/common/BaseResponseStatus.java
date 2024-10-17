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
    NOT_FOUND(false, 404, "페이지를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(false, 500, "서버에 예상치 못한 문제가 발생했습니다."),


    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),

    DELETE_ADDRESS(true, 1002, "배송지를 삭제했습니다."),
    NOT_FOUND_DELIVERY_ADDRESS(false, 1003, "존재하지 않는 배송지입니다."),

    /**
     * 2000: 유저, 등급, 팔로우
     */
    NOT_FOUND_MEMBER(false, 2000, "회원을 찾을 수 없습니다."),
    REQUIRED_VALUE_NOT_ENTERED(false, 2001, "필수값이 모두 입력되지 않았습니다."),
    NEED_TO_LOGIN(false, 2002, "로그인이 필요한 서비스입니다."),
    ALREADY_EXIST_MEMBER(false, 2003, "이미 존재하는 이메일입니다."),
    CANNOT_DELETE_MEMBER(false, 2004, "회원 삭제 과정 중 오류가 발생하였습니다."),


    /**
     * 2500: 쿠폰, 대기열
     */
    COUPON_ISSUED(true, 2500, "쿠폰이 발급되었습니다."),
    COUPON_NOT_FOUND(false, 2501, "쿠폰이 존재하지 않습니다."),
    COUPON_SOLD_OUT(false, 2502, "쿠폰이 모두 소진되었습니다. "),
    COUPON_ISSUANCE_PERIOD_NOT(false, 2503, "쿠폰 발급기간이 아닙니다."),
    COUPON_ALREADY_ISSUED(false, 2504, "이미 발급받은 쿠폰입니다."),
    FAIL_DELETE_MEMBER_COUPON(false, 2505, "발급된 쿠폰 삭제 실패"),
    FAIL_ISSUED_COUPON(false, 2506, "발급된 쿠폰 삭제 실패"),

    QUEUE_ENTERED(true,2600,"대기열에 등록됐습니다."),
    ALREADY_REGISTER_QUEUE(false,2601,"이미 대기열에 등록된 사용자입니다."),
    NOT_FOUND_RANK_AND_SIZE(false,2602,"대기순번 정보가 존재하지 않습니다."),
    FAIL_LOAD_SCAN_REDIS(false,2603, "Redis 스캔 실패"),
    NOT_FOUND_STATUS(false,2604, "대기열 상태 없음"),
    DELETE_QUEUE(true,2605, "대기열 삭제"),

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
    INVALID_CART_INFORMATION(false, 4003, "장바구니 정보가 일치하지 않습니다."),

    /**
     * 5000: QNA, 리뷰
     */
    NOT_FOUND_REVIEW(false, 5000, "리뷰가 존재하지 않습니다."),
    MIN_REVIEW_LENGTH(false, 5001, "리뷰는 15글자 이상 작성해야 합니다."),
    INVALID_RATING(false, 5002, "별점은 0점 이상 5점 이하이어야 합니다."),
    PURCHASE_REQUIRED(false, 5003, "해당 상품을 구매한 고객만 리뷰를 작성할 수 있습니다."),

    /**
     * 6000: 작가
     */
    NOT_FOUND_ATELIER(false, 6000, "작가를 찾을 수 없습니다."),

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
