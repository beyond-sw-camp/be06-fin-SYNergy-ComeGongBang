package com.synergy.backend.global.security;

import com.synergy.backend.global.jwt.JwtFilter;
import com.synergy.backend.global.jwt.JwtUtil;
import com.synergy.backend.global.security.filter.LoginFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;
    private final JwtUtil jwtUtil;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf((auth) -> auth.disable());
        http.httpBasic((auth) -> auth.disable());

        http.authorizeHttpRequests((auth)->
                auth
                        .requestMatchers("/test/user").hasRole("USER")
                        .requestMatchers("/test/admin").hasRole("ADMIN")
                        .anyRequest().permitAll()   // 일시적 모두 허용
        );

        http.logout((auth) ->
                auth
                        .logoutUrl("/logout")   // 로그아웃 url
                        .deleteCookies("JToken")    // 쿠키 삭제
                );

        http.addFilterBefore(new JwtFilter(jwtUtil), LoginFilter.class);
        http.addFilterAt(new LoginFilter(jwtUtil,authenticationManager(authenticationConfiguration)),
                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
