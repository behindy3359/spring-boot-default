package com.example.spring_security.security;

import com.example.spring_security.config.jwt.JwtProperties;
import com.example.spring_security.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Service
public class TokenProvider {
//  private static final String SECRET_KEY = "bmflkbgmfglbkfmgblkfmgblk";

  @Autowired
  private JwtProperties jwtProperties;

  //JWT 생성
  public String create(UserEntity entity){
    Date expiryDate = Date.from(
        Instant.now().plus(1, ChronoUnit.DAYS)
    );

    return Jwts.builder()
        //header
        .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret_key())
        //payload
        .setSubject(String.valueOf(entity.getId()))
        .setIssuer(jwtProperties.getIssuer())
        .setIssuedAt(new Date())
        .setExpiration(expiryDate)
        //토큰 생성
        .compact();
  }

  //토큰 디코딩 및 파싱, 토큰 위조 여부 확인 -> 사용자의 아이디 리턴

  public String validateAndGetUserId(String token){
    Claims claims = Jwts.parser()
        .setSigningKey(jwtProperties.getSecret_key())
        .parseClaimsJws(token) // base64 로 디코딩
        .getBody();
    return claims.getSubject();
  }

}
