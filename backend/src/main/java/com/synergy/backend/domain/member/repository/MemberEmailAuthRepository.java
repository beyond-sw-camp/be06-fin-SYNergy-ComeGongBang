package com.synergy.backend.domain.member.repository;

import com.synergy.backend.domain.member.model.entity.MemberEmailAuth;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO : 기존 RDB 방식 : 삭제
public interface MemberEmailAuthRepository extends JpaRepository<MemberEmailAuth, Long> {

    Optional<MemberEmailAuth> findByEmail(String email);

    Optional<MemberEmailAuth> findByEmailAndUuid(String email, String uuid);
}
