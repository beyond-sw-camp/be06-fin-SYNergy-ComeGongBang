package com.synergy.backend.member.controller;

import com.synergy.backend.member.model.request.MemberEmailAuthReq;
import com.synergy.backend.member.service.MemberEmailAuthService;
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

    private final MemberEmailAuthService memberEmailAuthService;

    @PostMapping("/request")
    public ResponseEntity<String> emailAuthentication(@RequestBody MemberEmailAuthReq req){
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
