package com.synergy.backend.domain.product.repository;

import com.synergy.backend.domain.product.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
