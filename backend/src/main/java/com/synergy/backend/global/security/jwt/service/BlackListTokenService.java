package com.synergy.backend.global.security.jwt.service;

import com.synergy.backend.global.security.jwt.repository.BlackListTokenRepository;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlackListTokenService {

    private final BlackListTokenRepository blackListTokenRepository;
    private final RedisTemplate<String, String> redisTemplate;

    public boolean checkBlackList(String accessToken, String refreshToken){
        boolean existAccess = false;
        boolean existRefresh = false;
        // accessToken이나 refreshToken이 블랙리스트에 포함되어 있는지 확인
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        if(accessToken != null){
//            existAccess = blackListTokenRepository.existsByToken(accessToken);
//            existAccess = redisTemplate.hasKey("blackToken:"+accessToken);
            existAccess = setOperations.isMember("blackToken", accessToken);

        }
        if(refreshToken != null){
//            existRefresh = blackListTokenRepository.existsByToken(refreshToken);
//            existRefresh = redisTemplate.hasKey("blackToken:"+refreshToken);
            existRefresh = setOperations.isMember("blackToken", refreshToken);
        }

        if(existAccess || existRefresh){
            return true;
        }
        return false;
    }

    public void save(String blackToken){
        // Redis의 Set 자료구조에 blackToken이라는 key로 accessToken 추가
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();
        setOperations.add("blackToken", blackToken);

//        redisTemplate.opsForValue().set("blackToken:"+blackToken,"", Duration.ofDays(7));
    }
}
