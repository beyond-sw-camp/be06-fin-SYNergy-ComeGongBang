package com.synergy.backend.domain.follow.repository;

import com.synergy.backend.domain.atelier.model.entity.Atelier;
import com.synergy.backend.domain.follow.model.entity.Follow;
import com.synergy.backend.domain.member.model.entity.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow,Long> {
    boolean existsByMemberAndAtelier(Member member, Atelier atelier);

    Optional<Follow> findByMemberAndAtelier(Member member, Atelier atelier);
}
