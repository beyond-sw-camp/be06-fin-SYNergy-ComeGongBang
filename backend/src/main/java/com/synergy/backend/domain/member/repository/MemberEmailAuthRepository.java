package com.synergy.backend.domain.member.repository;

import com.synergy.backend.domain.member.model.entity.MemberEmailAuth;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberEmailAuthRepository extends JpaRepository<MemberEmailAuth, Long> {

    Optional<MemberEmailAuth> findByEmail(String email);

    Optional<MemberEmailAuth> findByEmailAndUuid(String email, String uuid);
}
