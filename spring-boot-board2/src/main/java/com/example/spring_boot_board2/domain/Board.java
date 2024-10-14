package com.example.spring_boot_board2.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class Board {
  private Long id;
  private String title;
  private String content;
  private String writer;
  private LocalDateTime registered;
}
