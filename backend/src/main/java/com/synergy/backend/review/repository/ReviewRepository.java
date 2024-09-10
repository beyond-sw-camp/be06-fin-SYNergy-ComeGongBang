package com.synergy.backend.review.repository;

import com.synergy.backend.review.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> getAllByProductIdx(Long idx);
}
