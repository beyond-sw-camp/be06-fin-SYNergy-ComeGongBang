package com.synergy.backend.domain.product.querydsl;

import com.synergy.backend.domain.product.model.entity.Product;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface ProductRepositoryCustom {
    List<Product> search(String keyword, Pageable pageable);
    List<Product> searchCategory(Long categoryIdx, Integer price, Long memberIdx, Pageable pageable);
    List<Product> searchHashTag(Long hashtagIdx,Long memberIdx, Pageable pageable);
}
