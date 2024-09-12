package com.synergy.backend.domain.product.model.entity;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.hashtag.model.entity.ProductHashtag;
import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "product")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "atelier_idx")
    private Atelier atelier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_idx")
    private Category category;

    @Builder.Default
    @OneToMany(mappedBy = "product")
    List<ProductHashtag> productHashtagList = new ArrayList<>();

    private String name;
    private int price;
    private String description;
    private String thumbnailUrl;
    private int deliveryFee;
    private String type;
    private String expiration;
    private String manufacturing;
    private Double averageScore;

}
