package com.synergy.backend.domain.product.repository;

import com.synergy.backend.domain.product.model.entity.ProductMajorOptions;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductMajorOptionsRepository extends JpaRepository<ProductMajorOptions, Long> {

    @Query("SELECT pmo FROM ProductMajorOptions pmo " +
            "JOIN FETCH pmo.product p " +
            "JOIN FETCH pmo.productSubOptions pso " +
            "WHERE p.idx = :productIdx")
    List<ProductMajorOptions> findByProductIdx(@Param("productIdx") Long productIdx);
}
