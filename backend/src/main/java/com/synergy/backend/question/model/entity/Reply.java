package com.synergy.backend.question.model.entity;

import com.synergy.backend.atelier.model.entity.Atelier;
import com.synergy.backend.common.model.BaseEntity;
import com.synergy.backend.member.model.entity.Member;
import com.synergy.backend.product.model.entity.Product;
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