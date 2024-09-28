package com.synergy.backend.domain.atelier.service;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.atelier.model.response.AtelierProfileInfoRes;
import com.synergy.backend.domain.atelier.repository.AtelierRepository;
import com.synergy.backend.domain.follow.service.FollowService;
import com.synergy.backend.domain.likes.repository.LikesRepository;
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
    private final LikesRepository likesRepository;
    private final FollowService followService;

    // 특정 공방 상품 전체 조회기능 + 좋아요 추가
    public List<ProductListRes> atelierProductList(Long atelierIdx, Long memberIdx) throws BaseException {

        Member member = null;
        if (memberIdx != null) {
            member = memberRepository.findById(memberIdx).get();
        }

        // 1.공방 정보를 꺼내오고, 해당 공방의 상품정보를 꺼내온다.
        Atelier atelier = atelierRepository.findById(atelierIdx).orElseThrow(
                () -> new BaseException(BaseResponseStatus.NOT_FOUND_ATELIER)
        );
        List<Product> productsMadeByAtelier = productRepository.findAllByAtelier(atelier);

        List<ProductListRes> atelierProducts = new ArrayList<>();
        boolean isMemberLiked = false;
        for (Product p : productsMadeByAtelier) {
            // 2. 각 상품에 대해서 회원이 좋아요를 했는지 찾는다.
            if (member != null) {
                isMemberLiked = likesRepository.existsByMemberAndProduct(member, p);
            }

            // 3. 각 상품과 해당 상품을 회원이 좋아요 했는지를 상품정보에 담아서 보낸다.
            ProductListRes product = ProductListRes.builder()
                    .idx(p.getIdx())
                    .name(p.getName())
                    .price(p.getPrice())
                    .thumbnailUrl(p.getThumbnailUrl())
                    .averageScore(p.getAverageScore())
                    .atelier_name(atelier.getName())
                    .category_name(p.getCategory().getCategoryName())
                    .isMemberliked(isMemberLiked)
                    .build();
            atelierProducts.add(product);
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
