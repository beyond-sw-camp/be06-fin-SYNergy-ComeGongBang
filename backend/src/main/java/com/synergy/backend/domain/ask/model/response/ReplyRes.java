package com.synergy.backend.domain.ask.model.response;

import lombok.*;

//요청된 댓글 response구조
@Builder
@Getter
@Setter
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 포함한 생성자 자동 생성
public class ReplyRes {
    private Long memberIdx;
    private Long replyAtelierIdx;
    private String replyAteliername;
    private String replyAtelierProfileImageUrl;
    private String replyContent;

}

