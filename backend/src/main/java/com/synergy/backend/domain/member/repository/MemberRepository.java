package com.synergy.backend.domain.member.repository;

import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.member.model.entity.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);


    @Query("SELECT m FROM Member m WHERE (EXISTS (SELECT o FROM Orders o WHERE o.member = m AND o.modifiedAt > :oneMonth)) OR m.grade.idx >= 2")
    List<Member> findMembersWithRecentPurchaseOrGradeAbove(@Param("oneMonth") LocalDateTime oneMonth);

    List<Member> findByGradeIdx(Long gradeIdx);
}
