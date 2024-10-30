package com.synergy.backend.global.security.filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        log.error("CustomAuthenticationFailureHandler - onAuthenticationFailure : {}", exception.getMessage());

        // OAuth2AuthenticationException 인지 여부 확인
        if (exception instanceof OAuth2AuthenticationException) {
            OAuth2AuthenticationException oAuth2Exception = (OAuth2AuthenticationException) exception;
            OAuth2Error error = oAuth2Exception.getError();

            // 구체적인 OAuth2Error 정보 로깅
            log.error("OAuth2 Error - errorCode: {}, description: {}, uri: {}",
                    error.getErrorCode(),
                    error.getDescription(),
                    error.getUri());

            // 필요 시, 특정 에러 처리
            // 예: Invalid token 에러에 대해 특수한 처리
            if ("invalid_token".equals(error.getErrorCode())) {
                log.error("Invalid token error occurred");
            }
        }
    }
}
