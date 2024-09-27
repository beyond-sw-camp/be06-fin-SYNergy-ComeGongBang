package com.synergy.backend.domain.product.service;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.atelier.model.response.AtelierProfileInfoRes;
import com.synergy.backend.domain.atelier.service.AtelierService;
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
    private final AtelierService atelierService;

    public List<ProductListRes> search(String keyword, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "idx"));
        List<Product> result = productRepository.search(keyword, pageable);

        List<ProductListRes> response = new ArrayList<>();

        for (Product product : result) { //Todo : from으로 리펙토링하기(아래꺼도!)
            response.add(ProductListRes.builder()
                    .idx(product.getIdx())
                    .name(product.getName())
                    .price(product.getPrice())
                    .averageScore(product.getAverageScore())
//                    .atelier_name(product.getAtelier().getName())
                    .category_name(product.getCategory().getCategoryName())
                    .thumbnailUrl(product.getThumbnailUrl())
                    .isMemberliked(product.getIsMemberliked())
                    .build());
        }

        return response;
    }

    public List<ProductListRes> searchCategory(Long categoryIdx, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "idx"));
        List<Product> result = productRepository.searchCategory(categoryIdx, pageable);

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
                    .isMemberliked(product.getIsMemberliked())
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
                    .isMemberliked(product.getIsMemberliked())
                    .build());
        }
        return response;
    }

    public ProductInfoRes getProductInfo(Long productIdx, Long memberIdx) throws BaseException {
        Product product = productRepository.findByIdWithImages(productIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));

        Member member = memberRepository.findById(memberIdx).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

        // 작가 정보
        Atelier atelier = product.getAtelier();
        Long atelierIdx = atelier.getIdx();

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
        }

        // 상품 키워드(해시태그) 리스트
        List<String> productHashtags = productRepository.findHashtagsByProductIdx(productIdx);

        // 회원-상품 좋아요 여부 (정완-보류)

        // 상품 할인가 적용
        int productCalculateOnSalePrice = calculateOnSalePrice(productIdx);
        int productFinalOnSalePrice = product.getPrice() - productCalculateOnSalePrice;

        // 공방 정보 담아주기
        AtelierProfileInfoRes atelierProfileInfoRes = atelierService.getAtelierProfileInfo(atelier.getIdx(), memberIdx);

        ProductInfoRes response = ProductInfoRes.builder()
                .productIdx(product.getIdx())
                .atelierIdx(atelierIdx)
                .productName(product.getName())
                .productThumbnail(product.getThumbnailUrl())
                .productImages(productImagesRes)
                .productPrice(product.getPrice())
                .productOnSalePercent(product.getOnSalePercent())
                .productOnSalePrice(productCalculateOnSalePrice)
                .productFinalPrice(productFinalOnSalePrice)
                .productAverageScore(product.getAverageScore())
                .productOptions(productOptionsResList)
                .productDescription(product.getDescription())
                .productHashTags(productHashtags)
                .productLikeCount(product.getLikeCounts())
                .memberIsLike(product.getIsMemberliked()) // TODO : 정완 구현 보류
                .productExpiration(product.getExpiration())
                .productManufacturing(product.getManufacturing())
                .atelierProfileInfoRes(atelierProfileInfoRes)
                .build();

        return response;
    }

    private int calculateOnSalePrice(Long productIdx) throws BaseException {
        Product product = productRepository.findById(productIdx)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));

        int originPrice = product.getPrice();
        int onSalePercent = product.getOnSalePercent();

        int onSalePrice = originPrice / 100 * onSalePercent;

        return onSalePrice;

    }
}
