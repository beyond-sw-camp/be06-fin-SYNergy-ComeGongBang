package com.synergy.backend.domain.follow.repository;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.follow.model.entity.Follow;
import com.synergy.backend.domain.member.model.entity.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FollowRepository extends JpaRepository<Follow,Long> {
    boolean existsByMemberAndAtelier(Member member, Atelier atelier);

    Optional<Follow> findByMemberAndAtelier(Member member, Atelier atelier);

    @Query("SELECT a "
            + "FROM Atelier a "
            + "LEFT JOIN Follow f ON f.atelier = a "
            + "WHERE f.member = :member")
    List<Atelier> findFollowAtelierByMember(@Param("member") Member member);
}
