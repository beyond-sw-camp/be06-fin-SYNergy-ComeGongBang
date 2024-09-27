package com.synergy.backend.domain.product.repository;

import com.synergy.backend.domain.product.model.entity.ProductSubOptions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSubOptionsRepository extends JpaRepository<ProductSubOptions, Long> {
}
