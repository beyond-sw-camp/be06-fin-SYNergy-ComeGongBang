package com.synergy.backend.question.model.response;

import lombok.*;

//요청된 답글 response구조

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyResponseDTO {
    private Long atelierIdx;
    private Long memberIdx;
    private String ateliername;
    private String profileImageUrl;
    private String content;
}
