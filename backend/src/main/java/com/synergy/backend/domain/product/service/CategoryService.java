package com.synergy.backend.domain.product.service;

import com.synergy.backend.domain.product.model.entity.Category;
import com.synergy.backend.domain.product.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // 부모 카테고리 조회
    public List<Category> getTopCategories() {
        System.out.println(categoryRepository.findByParentCategoryIsNull());
        return categoryRepository.findByParentCategoryIsNull();
    }

    // 특정 상위카테고리의 하위 카테고리 조회
    public List<Category> getMiddleCategories(Long topCategoryIdx) {
        return categoryRepository.findByParentCategoryIdx(topCategoryIdx);
//                .orElseThrow(() -> new IllegalArgumentException("Top category not found"));

    }

    // 특정 중위카테고리의 하위 카테고리 조회
    public List<Category> getBottomCategories(Long middleCategoryIdx) {
        categoryRepository.findById(middleCategoryIdx)
                .orElseThrow(() -> new IllegalArgumentException("Middle category not found"));
        return categoryRepository.findByParentCategoryIdx(middleCategoryIdx);
    }
}
