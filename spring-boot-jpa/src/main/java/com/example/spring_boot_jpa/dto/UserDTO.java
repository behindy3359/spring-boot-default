package com.example.spring_boot_jpa.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor // 매개변수 없는 생성자
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자
@Builder // 디자인 패턴 중 빌더 패턴을 사용 가능하게 해줌
public class UserDTO {

  private Long id;
  private String username;
  private String email;
  private int no;
}
