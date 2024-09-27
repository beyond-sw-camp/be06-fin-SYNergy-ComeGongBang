package com.synergy.backend.domain.product.repository;

import com.synergy.backend.domain.product.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // 부모 카테고리가 null인 루트 카테고리 조회
    List<Category> findByParentCategoryIsNull();

    // 특정 부모 카테고리의 하위 카테고리 조회
    List<Category> findByParentCategoryIdx(Long parentCategoryIdx);

}

