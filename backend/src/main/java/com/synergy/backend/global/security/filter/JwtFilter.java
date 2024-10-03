package com.synergy.backend.global.security.filter;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.global.security.CustomUserDetails;
import com.synergy.backend.global.security.jwt.service.BlackListTokenService;
import com.synergy.backend.global.security.jwt.service.RefreshTokenService;
import com.synergy.backend.global.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final RefreshTokenService refreshTokenService;
    private final BlackListTokenService blackListTokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String accessToken = null;
        String refreshToken = null;
        //쿠키를 통한 요청 받기
        if(request.getCookies() != null){
            for(Cookie cookie : request.getCookies()){
                if(cookie.getName().equals("JToken")){
                    accessToken = cookie.getValue();
                }
                if (cookie.getName().equals("RefreshToken")) {
                    refreshToken = cookie.getValue();
                }
            }
        }

        // 블랙리스트에 등록되어 있으면 불법 토큰으로 판단
        if(blackListTokenService.checkBlackList(accessToken,refreshToken)){
            System.out.println("블랙리스트 토큰");

            // 불법 쿠키 삭제
            Cookie deleteAccessTokenCookie = new Cookie("JToken", null);
            deleteAccessTokenCookie.setMaxAge(0);
            deleteAccessTokenCookie.setPath("/");
            response.addCookie(deleteAccessTokenCookie);

            Cookie deleteRefreshTokenCookie = new Cookie("RefreshToken", null);
            deleteRefreshTokenCookie.setMaxAge(0);
            deleteRefreshTokenCookie.setPath("/");
            response.addCookie(deleteRefreshTokenCookie);

            filterChain.doFilter(request, response);
            return;
        }

        // JToken을 받지 못했으면 다음 필터로 넘기기.
        if(accessToken == null){
            filterChain.doFilter(request,response);
            return;
        }

        String token = accessToken;

        if(jwtUtil.isExpired(token)){
            System.out.println("Access 토큰 만료됨");
            if (refreshToken == null) { // 만료 + refresh 토큰이 없을 때
                System.out.println("refresh token이 없음");
                filterChain.doFilter(request, response);
                return;
            }

            String reIssuedAccessToken = refreshTokenService.reIssueAccessToken(refreshToken);
            if (reIssuedAccessToken == null) { // client의 refresh token이 변조되었거나, 만료되었거나, 서버가 가지고있는 refreshtoken과 다르거나
                System.out.println("refresh token이 null임");
                filterChain.doFilter(request, response);
                return;
            }

            token = reIssuedAccessToken;
            Cookie cookie = new Cookie("JToken", token);
            cookie.setHttpOnly(true);
//            cookie.setSecure(true);
            cookie.setPath("/");
            response.addCookie(cookie);

            refreshToken = refreshTokenService.reIssueRefreshToken(refreshToken); //RTR 적용
            Cookie reissuedRefreshToken = new Cookie("RefreshToken", refreshToken);
            reissuedRefreshToken.setHttpOnly(true);
//            reissuedRefreshToken.setSecure(true);
            reissuedRefreshToken.setPath("/");
            response.addCookie(reissuedRefreshToken);
        }

        //정상 토큰 및 만료시간 통과
        Long idx = jwtUtil.getIdx(token);
        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        // 인증-인가용 임시 멤버 객체 생성
        Member member = new Member(idx, username,role) ;

        // 직접 CustomDetails 객체로 변환
        CustomUserDetails customUserDetails = new CustomUserDetails(member);

        // ContextHolder에 미리 심어줌으로서, LoginFilter가 로그인 된 사용자라고 판명
        Authentication authToken = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request,response);
    }
}
