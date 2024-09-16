package com.synergy.backend.domain.orders.controller;

import com.fasterxml.jackson.databind.ser.Serializers.Base;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.orders.model.response.PresentRes;
import com.synergy.backend.domain.orders.service.PresentService;
import com.synergy.backend.global.common.BaseResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/present")
@RequiredArgsConstructor
public class PresentController {
    private final PresentService presentService;

    @GetMapping("/give")
    public BaseResponse<List<PresentRes>> giveList(){
        List<PresentRes> responses = presentService.giveList(Member.builder().idx(1L).build());
        return new BaseResponse<>(responses);
    }

    @GetMapping("/take")
    public BaseResponse<List<PresentRes>> takeList(){
        List<PresentRes> responses = presentService.takeList(Member.builder().idx(1L).build());
        return new BaseResponse<>(responses);
    }

}
