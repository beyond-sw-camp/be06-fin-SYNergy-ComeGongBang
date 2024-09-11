package com.synergy.backend.global.security.filter;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.global.security.CustomUserDetails;
import com.synergy.backend.global.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authorization = null;
        //쿠키를 통한 요청 받기
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("JToken")) {
                    authorization = cookie.getValue();
                }
            }
        }

        // JToken을 받지 못했으면 다음 필터로 넘기기.
        if (authorization == null) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorization;

        if (jwtUtil.isExpired(token)) {
            System.out.println("토큰 만료됨");
            filterChain.doFilter(request, response);
        }

        //정상 토큰 및 만료시간 통과
        Long idx = jwtUtil.getIdx(token);
        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        // 인증-인가용 임시 멤버 객체 생성
        Member member = new Member(idx, username, role);

        // 직접 CustomDetails 객체로 변환
        CustomUserDetails customUserDetails = new CustomUserDetails(member);

        // ContextHolder에 미리 심어줌으로서, LoginFilter가 로그인 된 사용자라고 판명
        Authentication authToken = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }
}
