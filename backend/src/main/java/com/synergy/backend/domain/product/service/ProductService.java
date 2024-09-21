package com.synergy.backend.domain.product.service;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.product.model.entity.ProductImages;
import com.synergy.backend.domain.product.model.entity.ProductMajorOptions;
import com.synergy.backend.domain.product.model.entity.ProductSubOptions;
import com.synergy.backend.domain.product.model.response.ProductImagesRes;
import com.synergy.backend.domain.product.model.response.ProductInfoRes;
import com.synergy.backend.domain.product.model.response.ProductMajorOptionsRes;
import com.synergy.backend.domain.product.model.response.ProductSubOptionsRes;
import com.synergy.backend.domain.product.repository.ProductMajorOptionsRepository;
import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.domain.product.model.response.ProductListRes;
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
    private final ProductMajorOptionsRepository productMajorOptionsRepository;

    public List<ProductListRes> search(Long categoryIdx, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "idx"));
        List<Product> result = productRepository.search(categoryIdx, pageable);

        List<ProductListRes> response = new ArrayList<>();

        for (Product product : result) {
            response.add(ProductListRes.builder()
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

    public List<ProductListRes> searchHashTag(Long hashtagIdx, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "idx"));
        List<Product> result = productRepository.searchHashTag(hashtagIdx, pageable);

        List<ProductListRes> response = new ArrayList<>();

        for (Product product : result) {
            response.add(ProductListRes.builder()
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

        // 상품 옵션들
        List<ProductMajorOptions> productMajorOptions = productMajorOptionsRepository.findByProductIdx(productIdx);

        List<ProductMajorOptionsRes> productOptionsResList = new ArrayList<>();

        for(ProductMajorOptions major : productMajorOptions){
            List<ProductSubOptionsRes> productSubOptionsResList = new ArrayList<>();
            // 소 옵션들을 리스트 형태로 담아놓기
            for(ProductSubOptions sub : major.getProductSubOptions()){
                productSubOptionsResList.add(
                        ProductSubOptionsRes.builder()
                                .name(sub.getName())
                                .inventory(sub.getInventory())
                                .addPrice(sub.getAddPrice())
                                .build()
                );
            }
            // 주옵션 리스트안에 소옵션 넣기
            productOptionsResList.add(
                    ProductMajorOptionsRes.builder()
                            .name(major.getName())
                            .subOptions(productSubOptionsResList)
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
                .productOptions(productOptionsResList)
                .atelierName(product.getAtelier().getName())
                .atelierProfileImage(product.getAtelier().getProfileImage())
//                .productHashTagList()
//                .memberIsLike()
//                .productLikeCount(product.get)
                .build();

        return response;
    }
}
