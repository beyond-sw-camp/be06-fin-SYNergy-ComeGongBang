package com.synergy.backend.domain.grade.model.entity;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grade")
@Getter
@AllArgsConstructor
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
}