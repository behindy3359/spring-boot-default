package com.example.spring_security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false)
  private Long id;

  @Column(name = "username", updatable = false)
  private String username;

  @Column(name = "email", nullable = false) // nullable 조건은 별도로 추가해주어야 함!
  private String email;

  @Column(name = "password", nullable = false)
  private String password;
}
