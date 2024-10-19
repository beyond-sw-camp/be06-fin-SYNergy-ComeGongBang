package com.synergy.backend.domain.likes.repository;

import com.synergy.backend.domain.likes.model.entity.Likes;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.product.model.entity.Product;
import com.synergy.backend.domain.product.model.response.ProductListRes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    //특정회원,상품으로 찜한상품조회
    Optional<Likes> findByMemberAndProduct(Member member, Product product);
    //특정회원이 찜한 모든 상품조회
    List<Likes> findAllByMember(Member member);

    @Query("SELECT l.product.idx FROM Likes l WHERE l.member.idx= :memberIdx")
    List<Long> findProductIdxByMember(Long memberIdx);

    boolean existsByMemberAndProduct(Member member, Product product);

    @Query("SELECT new com.synergy.backend.domain.product.model.response.ProductListRes( " +
            "p.idx, " +
            "p.name, " +
            "p.price, " +
            "p.thumbnailUrl, " +
            "p.averageScore, " +
            "p.atelier.name, " +
            "(CASE WHEN :memberIdx IS NOT NULL AND l IS NOT NULL THEN true ELSE false END), " +
            "(SELECT COUNT(lk) FROM Likes lk WHERE lk.product.idx = p.idx) " +
            ") " +
            "FROM Product p " +
            "LEFT JOIN Likes l ON p.idx = l.product.idx " +
            "WHERE l.member.idx = :memberIdx ")
    List<ProductListRes> findAllProductsByAtelier(Long memberIdx);
}
