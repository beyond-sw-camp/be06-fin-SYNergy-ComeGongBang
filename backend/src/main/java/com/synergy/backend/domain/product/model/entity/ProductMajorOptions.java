package com.synergy.backend.domain.product.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "product_major_options")
public class ProductMajorOptions extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "product_idx")
    private Product product;

    private String name;
}
