package com.synergy.backend.question.repository;

import com.synergy.backend.question.model.entity.Ask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AskRepository extends JpaRepository<Ask, Long> {
    List<Ask> findByProductIdx(Long productId);//특정 상품의 문의 목록 조회
    List<Ask> findByProductId(Long productId);
}
