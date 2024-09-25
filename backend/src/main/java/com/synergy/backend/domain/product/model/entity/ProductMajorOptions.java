package com.synergy.backend.domain.product.model.entity;

import com.synergy.backend.global.common.model.BaseEntity;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_major_options")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductMajorOptions extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @ManyToOne
    @JoinColumn(name = "product_idx")
    private Product product;

    @OneToMany(mappedBy = "majorOption")
    private List<ProductSubOptions> productSubOptions = new ArrayList<>();

    private String name;
}
