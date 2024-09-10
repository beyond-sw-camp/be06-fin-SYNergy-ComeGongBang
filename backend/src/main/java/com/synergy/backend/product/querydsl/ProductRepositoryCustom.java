package com.synergy.backend.product.querydsl;

import com.synergy.backend.product.model.entity.Product;
import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> search(Long categoryIdx);
    List<Product> searchHashTag(Long hashtagIdx);
}
