package com.example.spring_security.repository;

import com.example.spring_security.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  // 주어진 이메일로 사용자를 찾아 반환
  UserEntity findByEmail(String email);

  // 주어진 이메일을 가진 사용자가 존재하는지 여부 확인
  Boolean existsByEmail(String email);

  // 주어진 이메일과 비밀번호로 사용자를 찾아 반환
  UserEntity findByEmailAndPassword(String email, String password);
}
