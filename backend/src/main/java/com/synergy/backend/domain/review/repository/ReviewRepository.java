package com.synergy.backend.domain.review.repository;

import com.synergy.backend.domain.orders.model.entity.Orders;
import com.synergy.backend.domain.review.model.entity.Review;
import com.synergy.backend.domain.review.model.response.MyReviewListRes;
import com.synergy.backend.domain.review.model.response.ProductReviewRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT new com.synergy.backend.domain.review.model.response.ProductReviewRes(r.idx, m.nickname, m.profileImageUrl," +
            "COALESCE(MIN(ri.imageUrl), '') , r.createdAt, r.content, r.score) " +
            "FROM Review r " +
            "JOIN Member m ON r.member.idx = m.idx " +
            "LEFT JOIN ReviewImages ri ON r.idx = ri.review.idx " +
            "WHERE r.product.idx = :productIdx " +
            "GROUP BY r.idx, m.nickname, r.createdAt, r.content, r.score " +
            "ORDER BY r.createdAt DESC")
    Page<ProductReviewRes> findByProductIdx(Long productIdx, Pageable pageable);

    @Query("SELECT ri.imageUrl FROM ReviewImages ri LEFT JOIN Review r ON ri.review.idx = r.idx WHERE r.product.idx= :productIdx")
    Page<String> findReviewImageByProductIdx(Long productIdx, Pageable pageable);

    @Query("SELECT new com.synergy.backend.domain.review.model.response.MyReviewListRes(" +
            "r.idx, p.idx, p.name, " +
            "p.thumbnailUrl, r.createdAt, r.content, r.score) " +
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

    //작성 가능한 후기 목록
    @Query("SELECT o FROM Orders o LEFT JOIN Review r ON o.product.idx=r.product.idx and o.member.idx=r.member.idx "
            + "WHERE o.deliveryState='배송 완료' and o.paymentState='결제 완료' and o.member.idx= :memberIdx and r.idx IS NULL")
    Page<Orders> findAllByMemberAndState(Long memberIdx, Pageable pageable);

}
