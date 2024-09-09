package com.synergy.backend.member.repository;

import com.synergy.backend.member.model.entity.MemberEmailAuth;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberEmailAuthRepository extends JpaRepository<MemberEmailAuth, Long> {

    Optional<MemberEmailAuth> findByEmail(String email);

    Optional<MemberEmailAuth> findByEmailAndUuid(String email, String uuid);
}
