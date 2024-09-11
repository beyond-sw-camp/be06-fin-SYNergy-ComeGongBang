package com.synergy.backend.global.security.filter;

import com.synergy.backend.domain.member.model.entity.Member;
import com.synergy.backend.domain.member.model.request.MemberSignupReq;
import com.synergy.backend.domain.member.repository.MemberRepository;
import com.synergy.backend.global.util.JwtUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OAuth2Filter extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberRepository memberRepository;
    private final JwtUtil jwtUtil;

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

        // 회원 조회 후 DB에 없으면 회원가입
        if (!result.isPresent()) {
            MemberSignupReq memberSignupReq = new MemberSignupReq(email, nickname);

            member = MemberSignupReq.toEntity(memberSignupReq, new BCryptPasswordEncoder());

            memberRepository.save(member);
            isFirst = true;

        } else {
            member = result.get();
        }

        Long idx = member.getIdx();
        String role = member.getRole();
        String nick = member.getNickname();

        //토큰 발급
        String token = jwtUtil.createToken(idx, nickname, role, nick);

        Cookie jToken = new Cookie("JToken", token);
        jToken.setHttpOnly(true);
        jToken.setPath("/");
        response.addCookie(jToken);

        // 최초 로그인 -> 회원가입 진행시 로그인페이지 리다이렉트
        if(isFirst){
            getRedirectStrategy().sendRedirect(request, response,
                    "http://localhost:3000/login");
        }
        else {
            // 로그인이 성공하면, 메인페이지 리다이렉트
            getRedirectStrategy().sendRedirect(request, response,
                    "https://github.com/orgs/beyond-sw-camp/projects/89/views/1");
        }
    }
}
