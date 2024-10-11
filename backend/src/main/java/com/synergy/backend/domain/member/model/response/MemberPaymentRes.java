package com.synergy.backend.domain.member.model.response;

import com.synergy.backend.domain.member.model.entity.Member;
import lombok.Getter;

@Getter
public class MemberPaymentRes {
    private Long memberIdx;
    private String nickname;
    private String cellphone;
    private Long gradeIdx;
    private String gradeName;
    private Integer percent;
    private String gradeImageUrl;

    public MemberPaymentRes(Long memberIdx, String nickname, String cellphone, Long gradeIdx, String gradeName,
                            Integer percent, String gradeImageUrl) {
        this.memberIdx = memberIdx;
        this.nickname = nickname;
        this.cellphone = cellphone;
        this.gradeIdx = gradeIdx;
        this.gradeName = gradeName;
        this.percent = percent;
        this.gradeImageUrl = gradeImageUrl;
    }
}

