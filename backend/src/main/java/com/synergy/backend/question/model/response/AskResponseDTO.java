package com.synergy.backend.question.model.response;

import lombok.*;

//요청된 댓글 response구조
@Builder
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 포함한 생성자 자동 생성
public class AskResponseDTO {
    private Long memberIdx;
    private Long askIdx;
    private String username;
    private String profileImageUrl;
    private String content;
    private boolean isSecret;
    private ReplyResponseDTO replies; // 답글 정보
}

