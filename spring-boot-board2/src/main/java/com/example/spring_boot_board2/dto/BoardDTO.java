package com.example.spring_boot_board2.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
  private Long id;
  private String title;
  private String content;
  private String writer;
  private LocalDateTime registered;
}
