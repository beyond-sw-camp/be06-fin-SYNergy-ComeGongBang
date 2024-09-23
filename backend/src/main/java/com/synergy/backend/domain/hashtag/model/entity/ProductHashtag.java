package com.synergy.backend.domain.hashtag.model.entity;

import com.synergy.backend.domain.product.model.entity.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_hashtag")
public class ProductHashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "product_idx")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "hashtag_idx")
    private Hashtag hashtag;
}
