package com.synergy.backend.global.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.synergy.backend.global.util.JwtUtil;
import com.synergy.backend.global.security.CustomUserDetails;
import com.synergy.backend.domain.member.model.request.MemberLoginReq;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        MemberLoginReq req;
        try {
            req = new ObjectMapper().readValue(request.getReader(), MemberLoginReq.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String username = req.getEmail();
        String password = req.getPassword();

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,password,null);
        return authenticationManager.authenticate(authToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        CustomUserDetails authMember = (CustomUserDetails) authResult.getPrincipal();

        // 권한(Role) 및 정보 받아오기
        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        GrantedAuthority auth = authorities.iterator().next();
        String role = auth.getAuthority();

        Long idx = authMember.getIdx();
        String username = authMember.getUsername();
        String nickname = authMember.getNickname();

        String token = jwtUtil.createToken(idx, username,role, nickname);
        System.out.println(token);
        Cookie cookie = new Cookie("JToken", token);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        System.out.println("로그인 성공");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {

        // HTTP 상태 코드 설정 (예: 401 Unauthorized)
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        // 응답의 Content-Type을 JSON으로 설정
        response.setContentType("application/json;charset=UTF-8");

        // JSON 형태로 에러 메시지 전송
        String jsonResponse = String.format("{\"errorCode\": \"AUTHENTICATION_FAILED\", \"message\": \"%s\"}", failed.getMessage());
        response.getWriter().write(jsonResponse);

//        response.setStatus(401);
//        super.unsuccessfulAuthentication(request, response, failed);
    }
}
