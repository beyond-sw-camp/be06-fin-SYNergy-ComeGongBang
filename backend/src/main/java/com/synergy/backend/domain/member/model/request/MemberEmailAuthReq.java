package com.synergy.backend.domain.member.model.request;

import lombok.Getter;

@Getter
public class MemberEmailAuthReq {

    private String email;
    private String uuid;
}
