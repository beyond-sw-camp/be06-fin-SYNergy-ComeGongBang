package com.synergy.backend.product.repository;

import com.synergy.backend.product.model.entity.Product;
import com.synergy.backend.product.querydsl.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
}
