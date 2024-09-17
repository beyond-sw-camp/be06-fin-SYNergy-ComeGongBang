package com.synergy.backend.domain.member.repository;

import com.synergy.backend.domain.member.model.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
