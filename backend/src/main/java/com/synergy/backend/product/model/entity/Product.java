package com.synergy.backend.product.model.entity;

import com.synergy.backend.atelier.model.entity.Atelier;
import com.synergy.backend.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "atelier_idx")
    private Atelier atelier;

    @ManyToOne
    @JoinColumn(name = "category_idx")
    private Category category;

    private String name;
    private int price;
    private String description;
    private String thumbnailUrl;
    private int deliveryFee;
    private String type;
    private String expiration;
    private String manufacturing;
    private Double averageScore;

}
