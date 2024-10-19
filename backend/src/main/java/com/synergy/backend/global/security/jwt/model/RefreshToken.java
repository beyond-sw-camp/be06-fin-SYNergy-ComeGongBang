package com.synergy.backend.global.security.jwt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

//TODO : 기존 RDB 방식 : 삭제
@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
@Entity
//@RedisHash(value = "refreshToken", timeToLive = 7 * 24 * 60 * 60 * 1000L)
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String refreshToken;
    private String email;

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}