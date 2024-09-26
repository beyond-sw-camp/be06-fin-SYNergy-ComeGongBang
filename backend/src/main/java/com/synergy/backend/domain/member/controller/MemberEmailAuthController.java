package com.synergy.backend.domain.member.controller;

import com.synergy.backend.domain.member.service.MemberEmailAuthService;
import com.synergy.backend.domain.member.model.request.MemberEmailAuthReq;
import com.synergy.backend.domain.member.service.MemberService;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class MemberEmailAuthController {

    private final MemberService memberService;
    private final MemberEmailAuthService memberEmailAuthService;

    @PostMapping("/request")
    public ResponseEntity<String> emailAuthentication(@RequestBody MemberEmailAuthReq req) throws BaseException {
        memberService.isExistMember(req.getEmail());

        String uuid = memberEmailAuthService.sendEmail(req);
        String result = memberEmailAuthService.saveEmailAuthInfo(req,uuid);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/verify")
    public boolean verifyUuid(@RequestBody MemberEmailAuthReq req){
        boolean result = memberEmailAuthService.verifyUuid(req);
        return result;
    }
}
