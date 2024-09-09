package com.synergy.backend.orders.model.request;

import com.synergy.backend.member.model.entity.Member;
import com.synergy.backend.orders.model.entity.Cart;
import com.synergy.backend.product.model.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class AddCartReq {

    private Long productIdx;
    private Long count;
    private Integer price;
    private List<AddCartOption> addCartOptions;

    @Builder
    public AddCartReq(Long productIdx, Long count, Integer price) {
        this.productIdx = productIdx;
        this.count = count;
        this.price = price;
    }

    public Cart toEntity(Member member, Product product) {
        return Cart.builder()
                .member(member)
                .product(product)
                .price(this.price)
                .count(this.count)
                .build();
    }
}
