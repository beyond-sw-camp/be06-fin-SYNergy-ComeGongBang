package com.synergy.backend.domain.likes.service;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.atelier.repository.AtelierRepository;
import com.synergy.backend.domain.likes.model.entity.Likes;
import com.synergy.backend.domain.likes.model.response.LikesInfoResponse;
import com.synergy.backend.domain.likes.repository.LikesRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.model.response.ProductListRes;
import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.global.common.BaseResponseStatus;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LikesService {

    private final LikesRepository likesRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;
    private final AtelierRepository atelierRepository;


    //찜하기 추가,삭제기능
    @Transactional
    public LikesInfoResponse toggleLike(Long memberIdx, Long productIdx) throws BaseException {

        // 회원 조회
        Member member = memberRepository.findById(memberIdx)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_MEMBER));

        // 상품 조회
        Product product = productRepository.findById(productIdx)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NOT_FOUND_PRODUCT));

        LikesInfoResponse likesInfoResponse;
        // 찜한 기록이 있으면 해제
        // -> 찜 테이블에서 삭제
        // -> 상품에 대한 찜 카운트 빼기
        // -> 공방의 전체 상품에 대한 찜 카운트 빼기
        if (isLiked(member, product)) {
            unLiked(member, product);

            likesInfoResponse = LikesInfoResponse.builder()
                    .memberIsLiked(false)
                    .productLikesCount(product.getLikeCounts())
                    .atelierHavingProductsLikesCount(product.getAtelier().getHavingProductsLikeCount())
                    .build();

        } else {
            liked(member, product);

            likesInfoResponse = LikesInfoResponse.builder()
                    .memberIsLiked(true)
                    .productLikesCount(product.getLikeCounts())
                    .atelierHavingProductsLikesCount(product.getAtelier().getHavingProductsLikeCount())
                    .build();
        }
        return likesInfoResponse;
    }

    //찜을 했는지 여부확인
    public boolean isLiked(Member member, Product product){
        return likesRepository.existsByMemberAndProduct(member, product);
    }

    private void liked(Member member, Product product){
        Likes likes = Likes.builder()
                .member(member)
                .product(product)
                .build();
        likesRepository.save(likes);

        product.increaseLikedCount();
        productRepository.save(product);

        Atelier atelier = product.getAtelier();
        atelier.increaseLikedCount();
        atelierRepository.save(atelier);
    }

    private void unLiked(Member member, Product product){
        Likes likes = likesRepository.findByMemberAndProduct(member, product).get();
        likesRepository.delete(likes);

        product.decreaseLikedCount();
        productRepository.save(product);

        Atelier atelier = product.getAtelier();
        atelier.decreaseLikedCount();
        atelierRepository.save(atelier);
    }

    //상품전체조회기능



    //찜한상품 조회기능
    @Transactional(readOnly = true)
    public List<ProductListRes> getLikedProducts(Long memberIdx) throws BaseException {
        //회원조회
        Member member = memberRepository.findById(memberIdx)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        List<Product> ProductsList = productRepository.findAll();

        // 찜한 상품 리스트만 뽑아서 가져오기
        List<Product> likedProducts = likesRepository.findAllByMember(member).stream()
                .map(Likes::getProduct)
                .toList();

        // Product 리스트를 ProductListRes 리스트로 변환
        return likedProducts.stream()
                .map(product -> convertToProductListRes(product, true))
                .toList();
    }

    // Product를 ProductListRes로 변환하는 메소드
    private ProductListRes convertToProductListRes(Product product, boolean liked) {
        return ProductListRes.builder()
                .idx(product.getIdx())
                .name(product.getName())
                .price(product.getPrice())
                .thumbnailUrl(product.getThumbnailUrl())
                .averageScore(product.getAverageScore()) // 평균 점수 추가
                .atelier_name(product.getAtelier().getName()) // 아틀리에 이름 추가
                .category_name(product.getCategory().getCategoryName()) // 카테고리 이름 추가
                .isMemberliked(liked) // 찜 상태 추가
                .likeCounts(product.getLikeCounts())//찜 갯수
         .build();
    }
}


