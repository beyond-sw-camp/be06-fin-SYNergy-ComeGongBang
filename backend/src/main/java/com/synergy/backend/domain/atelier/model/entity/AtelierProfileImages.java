package com.synergy.backend.domain.atelier.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "atelier_profile_images")
public class AtelierProfileImages extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "atelier_idx")
    private Atelier atelier;

    private String imageUrl;
}