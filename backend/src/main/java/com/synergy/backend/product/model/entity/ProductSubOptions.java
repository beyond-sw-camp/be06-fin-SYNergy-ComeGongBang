package com.synergy.backend.product.model.entity;

import com.synergy.backend.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "product_sub_options")
@Getter
public class ProductSubOptions extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "major_option_idx")
    private ProductMajorOptions majorOption;

    private String name;
    private Integer inventory;
    private Integer addPrice;
}