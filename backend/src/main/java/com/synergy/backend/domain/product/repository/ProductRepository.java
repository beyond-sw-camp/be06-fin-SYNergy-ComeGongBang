package com.synergy.backend.domain.product.repository;

import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.querydsl.ProductRepositoryCustom;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {

    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.productImages WHERE p.idx = :productId")
    Optional<Product> findByIdWithImages(@Param("productId") Long productId);
}
