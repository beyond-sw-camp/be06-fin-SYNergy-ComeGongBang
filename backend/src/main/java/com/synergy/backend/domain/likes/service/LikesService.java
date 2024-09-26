package com.synergy.backend.domain.likes.service;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.likes.model.entity.Likes;
import com.synergy.backend.domain.likes.repository.LikesRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.model.response.ProductListRes;
import com.synergy.backend.domain.product.repository.ProductRepository;
import com.synergy.backend.global.exception.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikesService {

    private final LikesRepository likesRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;


    //찜하기 추가,삭제기능
    @Transactional
    public void toggleLike(Long memberIdx, Long productIdx) {

        // 회원 조회
        Member member = memberRepository.findById(memberIdx)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        // 상품 조회
        Product product = productRepository.findById(productIdx)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        //찜한기록을 먼저 조회해서
        //상품있으면 찜한 상품삭제 및 카운트 -1
        //상품없으면 추가 상품삭제 및 카운트 +1
        //찜 목록에 있는지 확인

        //찜한 기록이 있으면
        if (isLiked(member, product)) {
            //해당 작품의 찜 갯수 빼기
            product.decreaseLikedCount();
            //공방의 전체 작품의 찜 갯수빼기
            product.getAtelier().decreaseLikedCount();
            // 찜 목록에 있으면 삭제
            Likes existingLike = likesRepository.findByMemberAndProduct(member, product)
                    .orElseThrow(() -> new IllegalStateException("Like record not found"));
            likesRepository.delete(existingLike);
        } else {
            // 해당 작품의 찜 갯수 올리기
            product.increaseLikedCount();
            // 공방의 전체 작품의 찜 카운트 올리기
            product.getAtelier().increaseLikedCount();
            // 찜 목록에 없으면 추가
            likesRepository.save(new Likes(member, product));
        }
    }

    //찜을 했는지 여부확인
    public boolean isLiked(Member member, Product product){
        return likesRepository.existsByMemberAndProduct(member, product);
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


