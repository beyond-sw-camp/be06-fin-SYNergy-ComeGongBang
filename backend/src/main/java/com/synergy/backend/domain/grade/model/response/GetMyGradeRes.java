package com.synergy.backend.domain.grade.model.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetMyGradeRes {

    private String myGrade;
    private String expectedGrade;
    private String amountToNext;
    private String benefitMessage;
    private List<GradeRes> allGrades;

    public static GetMyGradeRes from(String myGrade, String expectedGrade, String amountToNext, List<GradeRes> allGrades, String benefitMessage) {
        return GetMyGradeRes.builder()
                .myGrade(myGrade)
                .expectedGrade(expectedGrade)
                .amountToNext(amountToNext)
                .allGrades(allGrades)
                .benefitMessage(benefitMessage)
                .build();
    }
}
