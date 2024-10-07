package com.synergy.backend.domain.follow.model.entity;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "follow")
@Getter
@NoArgsConstructor
public class Follow extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "member_idx")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "atelier_idx")
    private Atelier atelier;

    @Builder
    public Follow(Long idx, Member member, Atelier atelier) {
        this.idx = idx;
        this.member = member;
        this.atelier = atelier;
    }
}