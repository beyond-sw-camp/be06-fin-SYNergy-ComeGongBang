package com.synergy.backend.product.service;

import com.synergy.backend.product.model.dto.response.SearchProductRes;
import com.synergy.backend.product.repository.ProductRepository;
import com.synergy.backend.product.model.entity.Product;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<SearchProductRes> search(Long categoryIdx) {
        List<Product> result = productRepository.search(categoryIdx);

        List<SearchProductRes> response = new ArrayList<>();

        for (Product product : result) {
            response.add(SearchProductRes.builder()
                    .idx(product.getIdx())
                    .name(product.getName())
                    .price(product.getPrice())
                    .averageScore(product.getAverageScore())
//                    .atelier_name(product.getAtelier().getName())
                    .category_name(product.getCategory().getCategoryName())
                    .thumbnailUrl(product.getThumbnailUrl())
                    .build());
        }

        return response;
    }

    public List<SearchProductRes> searchHashTag(Long hashtagIdx) {
        List<Product> result = productRepository.searchHashTag(hashtagIdx);

        List<SearchProductRes> response = new ArrayList<>();

        for (Product product : result) {
            response.add(SearchProductRes.builder()
                    .idx(product.getIdx())
                    .name(product.getName())
                    .price(product.getPrice())
                    .averageScore(product.getAverageScore())
//                    .atelier_name(product.getAtelier().getName())
                    .category_name(product.getCategory().getCategoryName())
                    .thumbnailUrl(product.getThumbnailUrl())
                    .build());
        }
        return response;
    }
}
