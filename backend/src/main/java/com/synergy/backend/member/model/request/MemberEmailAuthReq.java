package com.synergy.backend.member.model.request;

import lombok.Getter;

@Getter
public class MemberEmailAuthReq {

    private String email;
    private String uuid;
}
