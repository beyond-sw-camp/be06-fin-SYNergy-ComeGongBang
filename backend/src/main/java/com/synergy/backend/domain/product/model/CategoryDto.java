package com.synergy.backend.domain.product.model;

import com.synergy.backend.domain.product.model.entity.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CategoryDto {

    private Long idx;
    private String categoryName;
    private Long categoryLevel;

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .idx(category.getIdx())
                .categoryName(category.getCategoryName())
                .categoryLevel(category.getCategoryLevel())
                .build();
    }

    public Category toEntity() {
        return Category.builder()
                .idx(this.idx)
                .categoryName(this.categoryName)
                .categoryLevel(this.categoryLevel)
                .build();
    }
}
