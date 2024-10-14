package com.synergy.backend.domain.member.repository;

import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.member.model.entity.Member;

import com.synergy.backend.domain.member.model.response.MemberPaymentRes;
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

    @Query("SELECT new com.synergy.backend.domain.member.model.response.MemberPaymentRes("
            + "m.idx, m.nickname, m.cellPhone, m.grade.idx, m.grade.name, m.grade.defaultPercent, m.grade.imageUrl) "
            + "FROM Member m LEFT JOIN Grade g ON m.grade.idx=g.idx WHERE m.idx= :memberIdx")
    MemberPaymentRes findMemberPaymentInfoByMemberIdx(Long memberIdx);
}

