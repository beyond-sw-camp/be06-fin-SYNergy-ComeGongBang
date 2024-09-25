package com.synergy.backend.domain.product.repository;

import com.synergy.backend.domain.product.model.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImagesRepository extends JpaRepository<ProductImages, Long> {
}
