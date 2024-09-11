package com.synergy.backend.domain.member.model.entity;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "follow")
public class Follow extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "atelier_idx")
    private Atelier atelier;
}