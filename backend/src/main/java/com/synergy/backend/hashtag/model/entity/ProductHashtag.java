package com.synergy.backend.hashtag.model.entity;

import com.synergy.backend.hashtag.model.entity.Hashtag;
import com.synergy.backend.product.model.entity.Product;
import jakarta.persistence.*;

@Entity
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
