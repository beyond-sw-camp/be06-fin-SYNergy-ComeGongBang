package com.synergy.backend.domain.hashtag.repository;

import com.synergy.backend.domain.hashtag.model.entity.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagRepository extends JpaRepository<Hashtag, Long> {
}
