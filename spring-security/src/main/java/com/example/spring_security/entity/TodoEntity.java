package com.example.spring_security.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="Todo")
public class TodoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "userId", nullable = false)
  private String UserId;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "done", nullable = false)
  private boolean done;
}
