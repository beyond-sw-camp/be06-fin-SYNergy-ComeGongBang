package com.synergy.backend.domain.ask.repository;

import com.synergy.backend.domain.ask.model.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByAtelierIdx(Long atelierIdx);
}
