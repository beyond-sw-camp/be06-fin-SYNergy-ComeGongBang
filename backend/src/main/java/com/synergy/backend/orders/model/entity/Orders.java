package com.synergy.backend.orders.model.entity;

import com.synergy.backend.common.model.BaseEntity;
import com.synergy.backend.member.model.entity.Member;
import com.synergy.backend.product.model.entity.Product;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_idx")
    private Product product;

    private String orderNumber;
    private int totalPrice;
    private String addressIdx;
    private String deliveryState;
    private String paymentState;
}