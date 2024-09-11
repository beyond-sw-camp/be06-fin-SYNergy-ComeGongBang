package com.synergy.backend.domain.review.repository;

import com.synergy.backend.domain.review.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
