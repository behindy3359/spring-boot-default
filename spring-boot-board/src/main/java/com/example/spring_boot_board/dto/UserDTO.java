package com.example.spring_boot_board3.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
  private Long id;
  private String username;
  private String email;
  private int no;
}
