package com.synergy.backend.domain.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MemberController {

    @GetMapping
    public String test(){
        return "test19";
    }

}
