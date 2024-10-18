package com.example.spring_security.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Service
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  @Autowired
  private TokenProvider tokenProvider;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    try{
      String token = parseBearerToken(request);
      log.info("JwtAuthenticationFilter is running ...");
      if(token!= null && !token.equalsIgnoreCase("null")){

        String userId = tokenProvider.validateAndGetUserId(token);
        log.info("Authenticated user id : " + userId);

        AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userId, null, AuthorityUtils.NO_AUTHORITIES);
        authentication.setDetails((new WebAuthenticationDetailsSource().buildDetails(request)));

        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(authentication);

        SecurityContextHolder.setContext(securityContext);
      }
    }catch (Exception e){
      log.error("Could not set User authentication in security context", 0);
    }
    filterChain.doFilter(request,response);
  }

  private String parseBearerToken(HttpServletRequest request){
    String bearerToken = request.getHeader("Authorization");

    if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
      return bearerToken.substring(7);
      // req.header jwt 토큰이 다음과 같이 들어있으므로 문자열 슬라이싱 진행하여 반환
      // Authentication: "Bearer asdfasdf.asdfasdf.asdfasdf"
    }
    return null;
  }

}
