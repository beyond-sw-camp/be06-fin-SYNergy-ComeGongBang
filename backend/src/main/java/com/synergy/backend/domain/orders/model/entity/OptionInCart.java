package com.synergy.backend.domain.orders.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import com.synergy.backend.domain.product.model.entity.ProductMajorOptions;
import com.synergy.backend.domain.product.model.entity.ProductSubOptions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "option_in_cart")
public class OptionInCart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "cart_idx")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "major_option_idx")
    private ProductMajorOptions majorOption;

    @ManyToOne
    @JoinColumn(name = "sub_option_idx")
    private ProductSubOptions subOption;
}