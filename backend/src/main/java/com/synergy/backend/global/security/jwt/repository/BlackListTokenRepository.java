package com.synergy.backend.global.security.jwt.repository;

import com.synergy.backend.global.security.jwt.model.BlackListToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListTokenRepository extends JpaRepository<BlackListToken, Long> {
    boolean existsByToken(String token);
}
