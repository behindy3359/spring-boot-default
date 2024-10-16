package com.example.spring_boot_board3.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="board")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 20)
  private String title;

  @Column(nullable = false, length = 100)
  private String content;

  @Column(nullable = false, length = 10)
  private String writer;

  @Column(
      name = "registered",
      nullable = false,
      updatable = false,
      columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
  )
  private LocalDateTime registered;


  @PrePersist
  protected  void onCreate(){
    registered = LocalDateTime.now();
  }
}
