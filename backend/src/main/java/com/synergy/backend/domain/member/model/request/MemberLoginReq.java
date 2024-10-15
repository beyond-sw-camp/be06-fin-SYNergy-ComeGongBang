package com.synergy.backend.domain.member.model.request;

import lombok.Getter;

@Getter
public class MemberLoginReq {
    private String email;
    private String password;
}
