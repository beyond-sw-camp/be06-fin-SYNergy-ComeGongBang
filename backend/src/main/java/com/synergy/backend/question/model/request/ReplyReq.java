package com.synergy.backend.question.model.request;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReplyReq {
    private Long askIdx;
    private Long replyAtelierIdx;
    private String replyAtelierName;
    private String replyAtelierProfileImage;
    private String replyContent;
}
