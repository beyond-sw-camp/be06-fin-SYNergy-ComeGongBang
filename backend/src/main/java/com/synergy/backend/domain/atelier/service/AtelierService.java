package com.synergy.backend.domain.atelier.service;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.atelier.model.response.AtelierProfileInfoRes;
import com.synergy.backend.domain.atelier.repository.AtelierRepository;
import com.synergy.backend.domain.follow.repository.FollowRepository;
import com.synergy.backend.domain.follow.service.FollowService;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
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
    private final MemberRepository memberRepository;
    private final FollowService followService;

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

        return atelierProducts;
    }

    public AtelierProfileInfoRes getAtelierProfileInfo(Long atelierIdx, Long memberIdx) throws BaseException {
        Atelier atelier = atelierRepository.findById(atelierIdx).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NOT_FOUND_ATELIER));

        // 회원 - 공방 팔로우 여부
        boolean memberIsFollow = false;
        if (memberIdx != null) {
            Member member = memberRepository.findById(memberIdx).get();
            memberIsFollow = followService.isFollow(member,atelier);
        }

        AtelierProfileInfoRes atelierProfileInfoRes = AtelierProfileInfoRes.builder()
                .atelierIdx(atelierIdx)
                .atelierProfileImage(atelier.getProfileImage())
                .atelierName(atelier.getName())
                .atelierAverageScore(atelier.getAverageScore())
                .havingProductsReviewCount(atelier.getHavingProductsReviewCount())
                .havingProductsLikeCount(atelier.getHavingProductsLikeCount())
                .havingFollowerCount(atelier.getHavingFollowerCount())
                .oneLineDescription(atelier.getOneLineDescription())
                .memberIsFollow(memberIsFollow)   //memberIdx 가 null 이면 무조건 false
                .build();

        return atelierProfileInfoRes;
    }
}
