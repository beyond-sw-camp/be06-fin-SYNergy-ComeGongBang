package com.synergy.backend.domain.grade.repository;

import com.synergy.backend.domain.grade.model.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {
}
