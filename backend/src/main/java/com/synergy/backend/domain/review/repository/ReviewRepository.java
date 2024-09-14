package com.synergy.backend.domain.review.repository;

import com.synergy.backend.domain.review.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM Review r JOIN FETCH r.member m JOIN FETCH r.product p WHERE p.idx = :productIdx")
    List<Review> findByProductIdx(Long productIdx);
}
