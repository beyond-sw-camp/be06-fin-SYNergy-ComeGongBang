package com.synergy.backend.domain.product.repository;

import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.querydsl.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
}
