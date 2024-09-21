package com.synergy.backend.domain.product.controller;

import com.synergy.backend.domain.product.model.CategoryDto;
import com.synergy.backend.domain.product.model.entity.Category;
import com.synergy.backend.domain.product.service.CategoryService;
import com.synergy.backend.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;


    // 대분류 카테고리 조회
    @GetMapping("/top")
    public BaseResponse<List<CategoryDto>> getTopCategories() {
        List<CategoryDto> topCategories = categoryService.getTopCategories().stream()
                .map(CategoryDto::toDto)
                .toList();
        return new BaseResponse<>(topCategories);
    }

    // 중분류 카테고리 조회
    @GetMapping("/middle/{topCategoryId}")
    public BaseResponse<List<CategoryDto>> getMiddleCategories(@PathVariable Long topCategoryId) {
        List<CategoryDto> middleCategories = categoryService.getMiddleCategories(topCategoryId).stream()
                .map(CategoryDto::toDto)
                .toList();
        return new BaseResponse<>(middleCategories);
    }

    // 소분류 카테고리 조회 (특정 중분류에 속한 소분류들)
    @GetMapping("/bottom/{middleCategoryId}")
    public BaseResponse<List<CategoryDto>> getBottomCategories(@PathVariable Long middleCategoryId) {
        List<CategoryDto> bottomCategories = categoryService.getBottomCategories(middleCategoryId).stream()
                .map(CategoryDto::toDto)  // 엔티티 -> DTO 변환
                .toList();
        return new BaseResponse<>(bottomCategories);
    }
}
