package com.synergy.backend.domain.grade.controller;

import com.synergy.backend.domain.grade.model.response.GetMyGradeRes;
import com.synergy.backend.domain.grade.model.response.GradeRes;
import com.synergy.backend.domain.grade.service.GradeService;
import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.exception.BaseException;
import com.synergy.backend.global.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mypage/grade")
@RequiredArgsConstructor
public class GradeController {

    private final GradeService gradeService;

    //내 등급 조회
    @GetMapping("/me")
    public BaseResponse<GetMyGradeRes> getMyGrade(@AuthenticationPrincipal CustomUserDetails customUserDetails) throws BaseException {
        GetMyGradeRes myGrade = gradeService.getMyGrade(customUserDetails.getIdx());
        return new BaseResponse<>(myGrade);
    }


    //모든 등급 조회
    @GetMapping("/info")
    public BaseResponse<List<GradeRes>> getAllGrade() {
        return new BaseResponse<>(gradeService.getAllGrade());
    }


}
