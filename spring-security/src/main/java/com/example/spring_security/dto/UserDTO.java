package com.example.spring_security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  private String token; // jwt 저장 공간
  private String email;
  private String username;
  private String password;
  private Long id;
}