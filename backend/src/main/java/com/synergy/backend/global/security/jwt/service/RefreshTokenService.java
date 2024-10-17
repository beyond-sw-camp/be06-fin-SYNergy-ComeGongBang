package com.synergy.backend.global.security.jwt.service;

import com.synergy.backend.global.security.jwt.repository.RefreshTokenRepository;
import com.synergy.backend.global.util.JwtUtil;
import jakarta.transaction.Transactional;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RefreshTokenService {

    private final JwtUtil jwtUtil;
    private final RedisTemplate<String,String> redisTemplate;

    public void save(String username, String refreshToken) {
//        RefreshToken existingRefreshToken = refreshTokenRepository.findByEmail(username).orElse(null);
//        RefreshToken refreshTokenEntity;
//        if (existingRefreshToken != null) {
//            refreshTokenEntity = RefreshToken.builder()
////                    .idx(existingRefreshToken.getIdx())
//                    .refreshToken(refreshToken)
//                    .email(username)
//                    .build();
//        } else {
//            refreshTokenEntity = RefreshToken.builder()
//                    .email(username)
//                    .refreshToken(refreshToken)
//                    .build();
//        }
//        refreshTokenRepository.save(refreshTokenEntity);
        redisTemplate.opsForValue().set("refreshToken:"+username,refreshToken, Duration.ofDays(7));

    }

    @Transactional
    public void delete(String refreshToken) {
        String email = jwtUtil.getUsername(refreshToken);
        if (email != null) {
//            refreshTokenRepository.deleteByEmail(email);
            redisTemplate.delete("refreshToken:"+refreshToken);
        }
    }

    // Access 토큰 재발급
    public String reIssueAccessToken(String refreshToken) {
        if (jwtUtil.isExpired(refreshToken)) {
            log.info("=====Refresh token 만료=====");
            return null;
        }

//        String email = jwtUtil.getUsername(token);
//        RefreshToken refreshTokenEntity = refreshTokenRepository.findByEmail(email).orElse(null);
        Boolean hasRefreshToken = redisTemplate.hasKey("refreshToken:"+jwtUtil.getUsername(refreshToken));
        if (hasRefreshToken) {
            String getRefreshToken = redisTemplate.opsForValue().get("refreshToken:"+jwtUtil.getUsername(refreshToken));
//            String refreshToken = refreshTokenEntity.getRefreshToken();
            if (jwtUtil.isValid(refreshToken) && refreshToken.equals(getRefreshToken)){
                log.info("=====Access Token 재발급=====");
                return jwtUtil.createToken(jwtUtil.getIdx(refreshToken), jwtUtil.getUsername(refreshToken),
                        jwtUtil.getRole(refreshToken),
                        jwtUtil.getNickname(refreshToken));
            }
        }
        return null;
    }

    // Refresh 토큰 재발급
    public String reIssueRefreshToken(String refreshToken) {
        log.info("=====Refresh Token 재발급=====");
        String reissuedRefreshToken = jwtUtil.createRefreshToken(jwtUtil.getIdx(refreshToken),jwtUtil.getUsername(refreshToken),
                jwtUtil.getRole(refreshToken), jwtUtil.getNickname(refreshToken));

//        RefreshToken refreshToken = refreshTokenRepository.findByEmail(jwtUtil.getUsername(token)).get(); // 기존의 refresh 토큰
//        refreshToken.updateRefreshToken(reissuedRefreshToken);
//        refreshTokenRepository.save(refreshToken);

        save(jwtUtil.getUsername(refreshToken), reissuedRefreshToken);  //새로운 refreshToken 으로 변경

        return reissuedRefreshToken;
    }
}

