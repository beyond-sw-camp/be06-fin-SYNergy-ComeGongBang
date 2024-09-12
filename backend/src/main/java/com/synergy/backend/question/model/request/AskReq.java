package com.synergy.backend.question.model.request;

import lombok.*;

//데이터전송객체
//읽기전용
//service와 db사이에서 data전송

//문의글요청
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AskReq {
    private Long memberIdx;
    private Long productIdx;
    private Long askIdx;
    private String content;
    private boolean isSecret;
}
