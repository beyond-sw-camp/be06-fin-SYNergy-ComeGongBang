package com.synergy.backend.global.config;

import com.synergy.backend.global.security.OAuth2Service;
import com.synergy.backend.global.security.filter.JwtFilter;
import com.synergy.backend.global.security.filter.LoginFilter;
import com.synergy.backend.global.security.filter.OAuth2Filter;
import com.synergy.backend.global.util.JwtUtil;
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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final OAuth2Filter oAuth2AuthorizationSuccessHandler;
    private final OAuth2Service oAuth2Service;
    private final AuthenticationConfiguration authenticationConfiguration;
    private final JwtUtil jwtUtil;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:3000"); // 허용할 출처
        config.addAllowedOrigin("http://localhost:8080"); // 허용할 출처

        config.addAllowedMethod("*"); // 허용할 메서드 (GET, POST, PUT 등)
        config.addAllowedHeader("*"); // 허용할 헤더
        config.setAllowCredentials(true); // 자격 증명 허용
        config.addExposedHeader("Access-Control-Allow-Origin");
        config.addExposedHeader("Authorization"); // 노출할 헤더 추가

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((auth) -> auth.disable());
        http.httpBasic((auth) -> auth.disable());

        http.authorizeHttpRequests((auth) ->
                auth
                        .requestMatchers("/test/user").hasRole("USER")
                        .requestMatchers("/test/admin").hasRole("ADMIN")
                        .anyRequest().permitAll()   // 일시적 모두 허용
        );

        http.logout((auth) ->
                auth
                        .logoutUrl("/logout")   // 로그아웃 url
                        .deleteCookies("JToken")    // 쿠키 삭제
                        .logoutSuccessHandler((request,response,authentication) -> {
                            response.sendRedirect("http://localhost:3000/");
                        })
        );

        http.addFilterBefore(new JwtFilter(jwtUtil), LoginFilter.class);
        http.addFilterAt(new LoginFilter(jwtUtil, authenticationManager(authenticationConfiguration)),
                UsernamePasswordAuthenticationFilter.class);

        http.oauth2Login((config) -> {
            config.successHandler(oAuth2AuthorizationSuccessHandler);
            config.userInfoEndpoint((endpoint) -> endpoint.userService(oAuth2Service));
        });
        return http.build();
    }
}
