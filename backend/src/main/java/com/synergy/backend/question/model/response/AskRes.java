package com.synergy.backend.question.model.response;

import lombok.*;

//요청된 댓글 response구조
@Builder
@Getter
@Setter
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 포함한 생성자 자동 생성
public class AskRes {
    private Long memberIdx;  // Member ID
    private String username;  // 사용자 이름
    private String profileImageUrl;  // 프로필 이미지
    private String content;  // 문의 내용
    private Long askIdx;  // 문의 ID
    private boolean isSecret;  // 비밀 여부
    private ReplyRes reply;  // 답변 정보
}

