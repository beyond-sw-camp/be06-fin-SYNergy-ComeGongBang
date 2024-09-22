package com.synergy.backend.domain.grade.model.response;

import com.synergy.backend.domain.grade.model.entity.Grade;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GradeRes {

    private Long gradeIdx;
    private String name;
    private Integer conditionMax;
    private Integer conditionMin;
    private Integer defaultPercent;

    private Integer recurPercent;
    private Integer recurNum;

    private Integer upgradePercent;
    private Integer upgradeNum;

    private String imageUrl;


    public static GradeRes from(Grade grade) {
        return GradeRes
                .builder()
                .gradeIdx(grade.getIdx())
                .name(grade.getName())
                .conditionMax(grade.getConditionMax())
                .conditionMin(grade.getConditionMin())
                .defaultPercent(grade.getDefaultPercent())
                .recurPercent(grade.getRecurPercent())
                .recurNum(grade.getRecurNum())
                .upgradePercent(grade.getUpgradePercent())
                .upgradeNum(grade.getUpgradeNum())
                .imageUrl(grade.getImageUrl())
                .build();
    }

}
