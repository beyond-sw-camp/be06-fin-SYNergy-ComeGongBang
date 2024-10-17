package com.synergy.backend.global.security.jwt.repository;

import com.synergy.backend.global.security.jwt.model.RefreshToken;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//TODO : 기존 RDB 방식 : 삭제
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByEmail(String email);

    void deleteByEmail(String email);
}
