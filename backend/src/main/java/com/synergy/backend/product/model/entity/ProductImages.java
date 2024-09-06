package com.synergy.backend.product.model.entity;

import com.synergy.backend.common.model.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "product_images")
public class ProductImages extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "product_idx")
    private Product product;

    private String imageUrl;
}
