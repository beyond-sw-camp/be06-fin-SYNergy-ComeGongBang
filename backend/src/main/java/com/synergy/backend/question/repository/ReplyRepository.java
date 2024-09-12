package com.synergy.backend.question.repository;

import com.synergy.backend.question.model.entity.Ask;
import com.synergy.backend.question.model.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByAtelierIdx(Long atelierIdx);
}
