package com.synergy.backend.global.security.jwt.service;

import com.synergy.backend.global.security.jwt.repository.BlackListTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlackListTokenService {

    private final BlackListTokenRepository blackListTokenRepository;

    public boolean checkBlackList(String accessToken, String refreshToken){
        boolean existAccess = false;
        boolean existRefresh = false;
        if(accessToken != null){
            existAccess = blackListTokenRepository.existsByToken(accessToken);
        }
        if(refreshToken != null){
            existRefresh = blackListTokenRepository.existsByToken(refreshToken);
        }

        if(existAccess || existRefresh){
            return true;
        }
        return false;
    }
}
