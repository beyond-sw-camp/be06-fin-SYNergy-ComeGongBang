package com.synergy.backend.global.security.jwt.repository;

import com.synergy.backend.global.security.jwt.model.BlackListToken;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO : 기존 RDB 방식 : 삭제
public interface BlackListTokenRepository extends JpaRepository<BlackListToken, Long> {
    boolean existsByToken(String token);
}
