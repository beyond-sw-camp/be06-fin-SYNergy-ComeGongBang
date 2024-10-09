package com.synergy.backend.global.security.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@NoArgsConstructor
@Getter
@Builder
@AllArgsConstructor
@RedisHash(value = "refreshToken", timeToLive = 7 * 24 * 60 * 60 * 1000L)
public class RefreshToken {

    @Id
    private String refreshToken;
    private String email;

    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}