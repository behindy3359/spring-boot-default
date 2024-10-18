package com.example.spring_security.config;

import com.example.spring_security.security.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@Slf4j
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  // 보안 필터 체인 구현
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors(withDefaults()) // cors 설정 (기본으로)
        .csrf(CsrfConfigurer::disable) // REST API 서버에서는 일반적으로 CSRF 보호가 필요 없어서 끔
        .sessionManagement(sessionManagement -> sessionManagement
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        // JWT 를 사용하고 있으므로 세션 관리하지 않음
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/", "/auth/**")
            .permitAll()
            .anyRequest().authenticated());
    // 요청의 인증을 "/", "/auth/**"경로는 인증없이 접근 가능 (그 외 모든 경로는 인증 필요)

    // CorsFilter 다음에 JWT 인증 필터 추가
    http.addFilterAfter(jwtAuthenticationFilter, CorsFilter.class);

    return http.build();
  }
  // CORS 설정 정의
  @Bean
  public CorsConfigurationSource corsConfigurationSource(){
    CorsConfiguration corsConfiguration = new CorsConfiguration();

    corsConfiguration.setAllowCredentials(true);
    corsConfiguration.setAllowedOriginPatterns(Arrays.asList("*"));
    corsConfiguration.setAllowedMethods(Arrays.asList("HEAD", "POST","GET","PUT","PATCH","DELETE"));
    corsConfiguration.setAllowedHeaders(Arrays.asList("*"));

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfiguration);

    return source;
  }

}