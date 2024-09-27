package com.synergy.backend.domain.orders.model.request;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.orders.model.entity.Cart;
import com.synergy.backend.domain.product.model.entity.Product;
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
    private String optionSummary;
    private List<AddCartOption> addCartOptions;

    @Builder
    public AddCartReq(Long productIdx, Integer count) {
        this.productIdx = productIdx;
        this.count = count;
    }

    public Cart toEntity(Member member, Product product) {
        return Cart.builder()
                .member(member)
                .product(product)
                .optionSummary(this.optionSummary)
                .count(this.count)
                .build();
    }
}
