package com.synergy.backend.domain.atelier.service;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.atelier.repository.AtelierRepository;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.model.response.ProductListRes;
import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtelierService {
    private final AtelierRepository atelierRepository;
    private final ProductRepository productRepository;

    public List<ProductListRes> atelierProductList(Long idx) throws BaseException {
        Atelier atelier = atelierRepository.findById(idx).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NOT_FOUND_ATELIER)
        );

        List<Product> results = productRepository.findAllByAtelier(atelier);

        List<ProductListRes> atelierProducts = new ArrayList<>();
        for (Product result : results) {
            atelierProducts.add(ProductListRes.builder()
                    .idx(result.getIdx())
                    .name(result.getName())
                    .price(result.getPrice())
                    .thumbnailUrl(result.getThumbnailUrl())
                    .averageScore(result.getAverageScore())
                    .atelier_name(atelier.getName())
                    .category_name(result.getCategory().getCategoryName()).build());
        }

        return  atelierProducts;
    }
}
