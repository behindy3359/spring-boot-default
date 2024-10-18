package com.example.spring_security.config.jwt;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("jwt")
@Getter
@Setter
@Component
public class JwtProperties {
  private String issuer;
  private String secret_key;
}
