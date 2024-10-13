package com.example.spring_boot_board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

  private Integer id;
  private String title;
  private String content;
  private String writer;
  private LocalDateTime registered;
}