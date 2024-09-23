package com.synergy.backend.domain.hashtag.repository;

import com.synergy.backend.domain.hashtag.model.entity.ProductHashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductHashTagRepository extends JpaRepository<ProductHashtag, Long> {
}
