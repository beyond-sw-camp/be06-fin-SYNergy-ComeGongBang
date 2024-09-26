package com.synergy.backend.domain.review.repository;

import com.synergy.backend.domain.review.model.entity.Review;
import com.synergy.backend.domain.review.model.response.MyReviewListRes;
import com.synergy.backend.domain.review.model.response.ProductReviewRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT new com.synergy.backend.domain.review.model.response.ProductReviewRes(r.idx, m.nickname, " +
            "COALESCE(ri.imageUrl, '') , r.createdAt, r.content, r.score) " +
            "FROM Review r " +
            "JOIN Member m ON r.member.idx = m.idx " +
            "LEFT JOIN ReviewImages ri ON r.idx = ri.review.idx " +
            "AND ri.idx = (SELECT MIN(ri2.idx) " +
            "              FROM ReviewImages ri2 " +
            "              WHERE ri2.review.idx = r.idx) " +
            "WHERE r.product.idx = :productIdx " +
            "ORDER BY r.createdAt DESC")
    Page<ProductReviewRes> findByProductIdx(Long productIdx, Pageable pageable);


    @Query("SELECT new com.synergy.backend.domain.review.model.response.MyReviewListRes(" +
            "r.idx, p.idx, p.name, " +
            "COALESCE(ri.imageUrl, ''), r.createdAt, r.content, r.score) " +
            "FROM Review r " +
            "JOIN Member m ON r.member.idx = m.idx " +
            "JOIN r.product p " +
            "LEFT JOIN ReviewImages ri ON r.idx = ri.review.idx " +
            "AND ri.idx = (SELECT MIN(ri2.idx) " +
            "              FROM ReviewImages ri2 " +
            "              WHERE ri2.review.idx = r.idx) " +
            "WHERE r.member.idx = :memberIdx " +
            "ORDER BY r.createdAt DESC")
    Page<MyReviewListRes> findByReVIewByMemberIdx(Long memberIdx, Pageable pageable);

}
