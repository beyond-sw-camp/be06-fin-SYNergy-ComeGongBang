package com.synergy.backend.domain.product.service;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.product.model.entity.ProductImages;
import com.synergy.backend.domain.product.model.response.ProductImagesRes;
import com.synergy.backend.domain.product.model.response.ProductInfoRes;
import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.domain.product.model.response.SearchProductRes;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;

    public List<SearchProductRes> search(Long categoryIdx, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "idx"));
        List<Product> result = productRepository.search(categoryIdx, pageable);

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

    public List<SearchProductRes> searchHashTag(Long hashtagIdx, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "idx"));
        List<Product> result = productRepository.searchHashTag(hashtagIdx, pageable);

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

    public ProductInfoRes getProductInfo(Long productIdx, Long memberIdx) throws BaseException {
        Product product = productRepository.findByIdWithImages(productIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));

        Member member = memberRepository.findById(memberIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_USER));

        // 상품 이미지들
        List<ProductImagesRes> productImagesRes = new ArrayList<>();

        for(ProductImages x : product.getProductImages()){
            productImagesRes.add(
                    ProductImagesRes.builder()
                            .productImageIdx(x.getIdx())
                            .productImageUrl(x.getImageUrl())
                            .build()
            );
        };

        ProductInfoRes response = ProductInfoRes.builder()
                .productIdx(product.getIdx())
                .productName(product.getName())
                .productPrice(product.getPrice())
                .productThumbnail(product.getThumbnailUrl())
                .productExpiration(product.getExpiration())
                .productManufacturing(product.getManufacturing())
                .productType(product.getType())
                .productDescription(product.getDescription())
                .productDeliveryFee(product.getDeliveryFee())
                .productAverageScore(product.getAverageScore())
                .productImages(productImagesRes)
//                .productOptions()
                .atelierName(product.getAtelier().getName())
                .atelierProfileImage(product.getAtelier().getProfileImage())
//                .productHashTagList()
//                .memberIsLike()
//                .productLikeCount(product.get)
                .build();

        return response;
    }
}
