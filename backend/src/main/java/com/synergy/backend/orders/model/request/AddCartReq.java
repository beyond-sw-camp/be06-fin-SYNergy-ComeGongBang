package com.synergy.backend.orders.model.request;

import com.synergy.backend.member.model.entity.Member;
import com.synergy.backend.orders.model.entity.Cart;
import com.synergy.backend.product.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddCartReq {

    private Long productIdx;
    private Integer count;
    private Integer price;
    private List<AddCartOption> addCartOptions;

    @Builder
    public AddCartReq(Long productIdx, Integer count, Integer price) {
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
