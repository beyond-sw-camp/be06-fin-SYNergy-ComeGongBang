package com.synergy.backend.domain.orders.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.product.model.entity.Product;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "orders")
@Getter
public class Orders extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idx")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_idx")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "present_idx")
    private Present present;

    private String orderNumber;
    private int totalPrice;
    private String addressIdx;
    private String deliveryState;
    private String paymentState;
}