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
    public List<Category> getParentCategories() {
        System.out.println(categoryRepository.findByParentCategoryIsNull());
        return categoryRepository.findByParentCategoryIsNull();
    }

    // 특정 부모카테고리의 하위 카테고리 조회
    public List<Category> getChildCategories(Long parentCategoryId) {
        Category parentCategory = categoryRepository.findById(parentCategoryId)
                .orElseThrow(() -> new IllegalArgumentException("Parent category not found"));
        return categoryRepository.findByParentCategory(parentCategory);
    }
}
