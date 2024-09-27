package com.synergy.backend.domain.grade.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grade")
@Getter
@NoArgsConstructor
public class Grade extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String name;
    private Integer defaultPercent;
    private Integer gradeRange;

    private Integer recurPercent;
    private Integer recurNum;

    private Integer upgradePercent;
    private Integer upgradeNum;

    private String imageUrl;
    private Integer conditionMin;
    private Integer conditionMax;

    @Builder
    public Grade(Long idx, String name, Integer defaultPercent, Integer gradeRange, Integer recurPercent,
                 Integer recurNum,
                 Integer upgradePercent, Integer upgradeNum, String imageUrl, Integer conditionMin,
                 Integer conditionMax) {
        this.idx = idx;
        this.name = name;
        this.defaultPercent = defaultPercent;
        this.gradeRange = gradeRange;
        this.recurPercent = recurPercent;
        this.recurNum = recurNum;
        this.upgradePercent = upgradePercent;
        this.upgradeNum = upgradeNum;
        this.imageUrl = imageUrl;
        this.conditionMin = conditionMin;
        this.conditionMax = conditionMax;
    }
}