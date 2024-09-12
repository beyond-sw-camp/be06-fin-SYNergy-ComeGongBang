package com.synergy.backend.question.repository;

import com.synergy.backend.question.model.entity.Ask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AskRepository extends JpaRepository<Ask, Long> {
    List<Ask> findByProductIdx(Long productId);
}
