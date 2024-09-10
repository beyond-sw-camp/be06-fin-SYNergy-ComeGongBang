package com.synergy.backend.product.model.entity;

import com.synergy.backend.atelier.model.entity.Atelier;
import com.synergy.backend.common.model.BaseEntity;
import com.synergy.backend.hashtag.model.entity.ProductHashtag;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;

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

    @ManyToOne
    @JoinColumn(name = "category_idx")
    private Category category;

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
