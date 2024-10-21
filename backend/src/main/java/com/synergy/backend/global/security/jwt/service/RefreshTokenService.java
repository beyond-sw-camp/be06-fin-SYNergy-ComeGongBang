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
            log.info("=====RefreshToken 서버에 보유중=====");
            String getRefreshToken = redisTemplate.opsForValue().get("refreshToken:"+jwtUtil.getUsername(refreshToken));
            String getBackupRefreshToken = redisTemplate.opsForValue().get("backupRefreshToken:"+jwtUtil.getUsername(refreshToken));
//            String refreshToken = refreshTokenEntity.getRefreshToken();
            log.info("=====유저가 들고온 refreshToken : =====" + refreshToken);
            log.info("=====서버가 가지고 있는 refreshToken : =====" + getRefreshToken);
            if (jwtUtil.isValid(refreshToken) && (refreshToken.equals(getRefreshToken) || refreshToken.equals(getBackupRefreshToken))){
                log.info("=====Access Token 재발급=====");
                return jwtUtil.createToken(jwtUtil.getIdx(refreshToken), jwtUtil.getUsername(refreshToken),
                        jwtUtil.getRole(refreshToken),
                        jwtUtil.getNickname(refreshToken));
            } else{
                log.error("=====refresh Token이 이상하거나, 들고있는 refreshToken이 서버와 다름=====");
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

        // 기존 RefreshToken을 백업하고 10초 동안 유효하게 처리
        redisTemplate.opsForValue().set("backupRefreshToken:" + jwtUtil.getUsername(refreshToken),
                refreshToken,
                Duration.ofSeconds(10));

        save(jwtUtil.getUsername(refreshToken), reissuedRefreshToken);  //새로운 refreshToken 으로 변경
        return reissuedRefreshToken;
    }
}

