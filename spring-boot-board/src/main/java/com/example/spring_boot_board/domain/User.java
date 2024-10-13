package com.example.spring_boot_board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

  private Long id;
  private String username;
  private String email;
  private String createdAt;
}
