package com.synergy.backend.domain.product.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_sub_options")
@Getter
@NoArgsConstructor
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