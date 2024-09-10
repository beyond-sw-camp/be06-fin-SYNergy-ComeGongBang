package com.synergy.backend.question.repository;

import com.synergy.backend.question.model.entity.Ask;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AskRepository extends JpaRepository <Ask, Long> {
}
