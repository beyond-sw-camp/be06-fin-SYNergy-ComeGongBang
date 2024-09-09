package com.synergy.backend.review.model.entity;

import com.synergy.backend.common.model.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "review_images")
public class ReviewImages extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "review_idx")
    private Review review;

    private String imageUrl;
}
