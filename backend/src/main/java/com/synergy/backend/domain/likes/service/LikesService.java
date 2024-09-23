package com.synergy.backend.domain.likes.service;

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
        //상품있으면 삭제
        //상품없으면 추가
        // 찜 목록에 있는지 확인
        Optional<Likes> existingLike = likesRepository.findByMemberAndProduct(member, product);

        if (existingLike.isPresent()) {
            // 찜 목록에 있으면 삭제
            likesRepository.delete(existingLike.get());
        } else {
            // 찜 목록에 없으면 추가
            likesRepository.save(new Likes(member, product));
        }
    }

    //찜한상품 조회기능
    @Transactional(readOnly = true)
    public List<ProductListRes> getLikedProducts(Long memberIdx) throws BaseException {
        //회원조회
        Member member = memberRepository.findById(memberIdx)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));


        // 찜한 상품 리스트만 뽑아서 가져오기

        // 찜한 상품 리스트만 뽑아서 가져오기
        List<Product> likedProducts = likesRepository.findAllByMember(member).stream()
                .map(Likes::getProduct)
                .toList();

        // Product 리스트를 ProductListRes 리스트로 변환
        return likedProducts.stream()
                .map(product -> convertToProductListRes(product, true))
                .toList(); // Java 16 이상에서 사용 가능, 이전 버전은 collect(Collectors.toList()) 사용
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
                .liked(product.getLiked()) // 찜 상태 추가
                .build();
    }
}


