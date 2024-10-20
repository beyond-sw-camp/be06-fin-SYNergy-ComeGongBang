package com.synergy.backend.domain.grade.repository;

import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.member.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    @Query("SELECT g.defaultPercent FROM Grade g JOIN FETCH Member m ON m.grade = g WHERE m=:member")
    Integer findDrageDiscountPercentByMember(Member member);
}
