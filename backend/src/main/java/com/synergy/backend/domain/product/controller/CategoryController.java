package com.synergy.backend.domain.product.controller;

import com.synergy.backend.domain.product.model.entity.Category;
import com.synergy.backend.domain.product.service.CategoryService;
import com.synergy.backend.global.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // 루트 카테고리 조회
    @GetMapping("/parent")
    public BaseResponse<List<Category>> getParentCategories() {
        List<Category> parentCategories = categoryService.getParentCategories();
        System.out.println(parentCategories);
        return new BaseResponse<>(parentCategories);
    }

    // 특정 부모 카테고리의 하위 카테고리 조회
    @GetMapping("/child/{parentIdx}")
    public BaseResponse<List<Category>> getChildCategories(@PathVariable Long parentIdx) {
        List<Category> childrenCategories = categoryService.getChildCategories(parentIdx);
        return new BaseResponse<>(childrenCategories);
    }
}
