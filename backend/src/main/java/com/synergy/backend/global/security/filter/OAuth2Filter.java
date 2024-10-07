package com.synergy.backend.global.security.filter;

import com.synergy.backend.domain.grade.model.entity.Grade;
import com.synergy.backend.domain.grade.repository.GradeRepository;
import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.model.request.MemberSignupReq;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.global.security.CustomUserDetails;
import com.synergy.backend.global.security.jwt.service.RefreshTokenService;
import com.synergy.backend.global.util.JwtUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuth2Filter extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberRepository memberRepository;
    private final GradeRepository gradeRepository;
    private final JwtUtil jwtUtil;
    private final RefreshTokenService refreshTokenService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

        Map<String, Object> properties = (Map<String, Object>) oAuth2User.getAttributes().get("properties");
        String nickname = (String) properties.get("nickname");

        Map<String, Object> kakaoAccount = (Map<String, Object>) oAuth2User.getAttributes().get("kakao_account");
        String email = (String) kakaoAccount.get("email");

        System.out.println(nickname);
        System.out.println(email);

        Member member = null;
        boolean isFirst = false;

        Optional<Member> result = memberRepository.findByEmail(email);
        Grade grade = gradeRepository.findById(1L).get();

        // 회원 조회 후 DB에 없으면 회원가입
        if (!result.isPresent()) {
            MemberSignupReq memberSignupReq = new MemberSignupReq(email, nickname);

            member = MemberSignupReq.toEntity(memberSignupReq, new BCryptPasswordEncoder(),grade);

            memberRepository.save(member);
            isFirst = true;

        } else {
            member = result.get();
        }

        Long idx = member.getIdx();
        String role = member.getRole();
        String nick = member.getNickname();

        // 인증-인가용 임시 멤버 객체 생성
        Member tokenMember = new Member(idx, nick,role) ;

        // 직접 CustomDetails 객체로 변환
        CustomUserDetails customUserDetails = new CustomUserDetails(tokenMember);

        // ContextHolder에 미리 심어줌으로서, LoginFilter가 로그인 된 사용자라고 판명
        Authentication authToken = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);

        //토큰 발급
        String token = jwtUtil.createToken(idx, nickname, role, nick);
        String refreshToken = jwtUtil.createRefreshToken(idx,nickname,role,nickname);
        synchronized(this) {
            refreshTokenService.save(nickname, refreshToken);
        }

        Cookie jToken = new Cookie("JToken", token);
        jToken.setHttpOnly(true);
        jToken.setPath("/");
        response.addCookie(jToken);

        Cookie refreshCookie = new Cookie("RefreshToken", refreshToken);
        refreshCookie.setPath("/");
        refreshCookie.setHttpOnly(true);
//        refreshCookie.setSecure(true);
        response.addCookie(refreshCookie);

        // 최초 로그인 -> 회원가입 진행시 로그인페이지 리다이렉트
//        if(isFirst){
//            getRedirectStrategy().sendRedirect(request, response,
//                    "http://localhost:3000/login");
//        }
//        else {
            // 로그인이 성공하면, 메인페이지 리다이렉트
        getRedirectStrategy().sendRedirect(request, response,
                "http://localhost:3000/login-callback");

            // 클라이언트 측에서 응답을 받을 수 있게, JSON 형태로 응답 전송
//            response.setContentType("application/json;charset=UTF-8");
//            response.setStatus(HttpServletResponse.SC_OK);
//        }
    }
}
