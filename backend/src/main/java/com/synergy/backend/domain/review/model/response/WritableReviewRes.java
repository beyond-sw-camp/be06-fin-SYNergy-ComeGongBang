package com.synergy.backend.domain.review.model.response;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.product.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WritableReviewRes {
    Long productIdx;
    String productName;
    String productThumbnail;
    Long atelierIdx;
    String atelierName;
    String optionString;

    public static WritableReviewRes from(Product product, Atelier atelier, String optionString){
        return WritableReviewRes.builder()
                .productIdx(product.getIdx())
                .productName(product.getName())
                .productThumbnail(product.getThumbnailUrl())
                .atelierIdx(atelier.getIdx())
                .atelierName(atelier.getName())
                .optionString(optionString)
                .build();
    }
}

