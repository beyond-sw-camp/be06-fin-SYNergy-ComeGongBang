package com.synergy.backend.question.model.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 포함한 생성자 자동 생성
public class AskResponseDTO {
    private Long memberIdx;
    private Long askIdx;
    private String username;
    private String profileImageUrl;
    private String content;
    private boolean isSecret;
    private ReplyResponseDTO replies; // 응답 구조 안의 답변 정보 포함
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReplyResponseDTO {
    private Long atelierIdx;
    private Long memberIdx;
    private String ateliername;
    private String profileImageUrl;
    private String content;
}
