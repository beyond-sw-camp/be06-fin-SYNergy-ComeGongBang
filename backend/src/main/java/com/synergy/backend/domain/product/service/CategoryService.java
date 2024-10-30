package com.synergy.backend.domain.product.service;

import com.synergy.backend.domain.product.model.CategoryDto;
import com.synergy.backend.domain.product.model.entity.Category;
import com.synergy.backend.domain.product.repository.CategoryRepository;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    //TODO : 중복 코드 제거

    // 부모 카테고리 조회
    public List<CategoryDto> getTopCategories() {
        List<Category> categories = categoryRepository.findByParentCategoryIsNull();

        List<CategoryDto> categoryDtos = new ArrayList<>();
        for(Category category : categories){
            CategoryDto dto = CategoryDto.toDto(category);
            categoryDtos.add(dto);
        }

        return categoryDtos;
    }

    // 특정 상위카테고리의 하위 카테고리 조회
    public List<CategoryDto> getMiddleCategories(Long topCategoryIdx) {
        List<Category> categories = categoryRepository.findByParentCategoryIdxWithSubCategories(topCategoryIdx);
        
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for(Category category : categories){
            CategoryDto dto = CategoryDto.toDto(category);
            categoryDtos.add(dto);
        }
        
        return categoryDtos;
    }

    // 특정 중위카테고리의 하위 카테고리 조회
    public List<CategoryDto> getBottomCategories(Long middleCategoryIdx) {
        List<Category> categories = categoryRepository.findByParentCategoryIdxWithSubCategories(middleCategoryIdx);

        List<CategoryDto> categoryDtos = new ArrayList<>();
        for(Category category : categories){
            CategoryDto dto = CategoryDto.toDto(category);
            categoryDtos.add(dto);
        }

        return categoryDtos;
    }
}
