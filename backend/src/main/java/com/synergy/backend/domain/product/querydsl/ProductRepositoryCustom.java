package com.synergy.backend.domain.product.querydsl;

import com.synergy.backend.domain.product.model.entity.Product;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface ProductRepositoryCustom {
    List<Product> search(Long categoryIdx, Pageable pageable);
    List<Product> searchHashTag(Long hashtagIdx, Pageable pageable);
}
