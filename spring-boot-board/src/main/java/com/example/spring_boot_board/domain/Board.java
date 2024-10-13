package com.example.spring_boot_board.domain;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
public class Board {

  private Integer id;
  private String title;
  private String content;
  private String writer;
  private LocalDateTime registered;
}
