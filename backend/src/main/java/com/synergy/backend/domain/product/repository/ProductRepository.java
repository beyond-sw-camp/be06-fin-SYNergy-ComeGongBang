package com.synergy.backend.domain.product.repository;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.querydsl.ProductRepositoryCustom;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductRepositoryCustom {
    List<Product> findAllByAtelier(Atelier atelier);
}
