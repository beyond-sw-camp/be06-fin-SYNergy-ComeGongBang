package com.synergy.backend.domain.likes.repository;

import com.synergy.backend.domain.likes.model.entity.Likes;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.product.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    //특정회원,상품으로 찜한상품조회
    Optional<Likes> findByMemberAndProduct(Member member, Product product);
    //특정회원이 찜한 모든 상품조회
    List<Likes> findAllByMember(Member member);
    boolean existsByMemberAndProduct(Member member, Product product);
}