package com.synergy.backend.domain.ask.model.entity;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reply")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reply extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "atelier_idx")
    private Atelier atelier;

    @OneToOne
    @JoinColumn(name = "ask_idx")
    private Ask ask;

    private String replyname;
    private String replyProfileImageUrl;
    private String replyContent;


}