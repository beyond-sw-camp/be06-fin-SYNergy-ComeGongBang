package com.synergy.backend.domain.alert.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import com.synergy.backend.domain.member.model.entity.Member;
import jakarta.persistence.*;

@Entity
@Table(name = "alert")
public class Alert extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;
}
