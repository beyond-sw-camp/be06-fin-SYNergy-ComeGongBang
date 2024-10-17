package com.synergy.backend.global.security.jwt.service;

import com.synergy.backend.global.security.jwt.repository.BlackListTokenRepository;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlackListTokenService {

    private final BlackListTokenRepository blackListTokenRepository;
    private final RedisTemplate<String, String> redisTemplate;

    public boolean checkBlackList(String accessToken, String refreshToken){
        boolean existAccess = false;
        boolean existRefresh = false;
        if(accessToken != null){
//            existAccess = blackListTokenRepository.existsByToken(accessToken);
            existAccess = redisTemplate.hasKey("blackToken:"+accessToken);
        }
        if(refreshToken != null){
//            existRefresh = blackListTokenRepository.existsByToken(refreshToken);
            existRefresh = redisTemplate.hasKey("blackToken:"+refreshToken);
        }

        if(existAccess || existRefresh){
            return true;
        }
        return false;
    }

    public void save(String blackToken){
        redisTemplate.opsForValue().set("blackToken:"+blackToken,"", Duration.ofDays(7));
    }
}
