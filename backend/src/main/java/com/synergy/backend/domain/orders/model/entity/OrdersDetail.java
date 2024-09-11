package com.synergy.backend.domain.orders.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import com.synergy.backend.domain.product.model.entity.ProductSubOptions;
import jakarta.persistence.*;

@Entity
@Table(name = "orders_detail")
public class OrdersDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "order_idx")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "idx2")
    private ProductSubOptions productSubOption;

    private Integer productCount;
}