package com.example.spring_boot_jpa.repository;

import com.example.spring_boot_jpa.dto.UserDTO;
import com.example.spring_boot_jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
//  Optional<UserEntity> findByUsername(String username);
//
  //case 1.
//  List<UserEntity> findByUsername(String username); // select * from user where username = ?//
//  List<UserEntity> findByUsernameContainingOrEmailContaining(String username, String email);
//  boolean existsByUsername(String username);
//
  //case 2.
//  @Query("SELECT u FROM User u WHERE u.username= :username")
//  List<UserEntity> findByUsername(@Param("username") String username);
//
//  @Query("SELECT u FROM User u WHERE u.username LIKE %:keyword% OR u.email LIKE %:keyword%")// select * from user where username = ?//
//  List<UserEntity> findByUsernameContainingOrEmailContaining(@Param("keyword") String keyword);
//
//  @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM USER u WHERE u.username = :username")
//  // 참고. CASE WHEN ( 조건식 ) THEN (결과 1) ELSE (결과 2) END : SQL 조건문
//  boolean existsByUsername(@Param("username") String username);
// 1. 사용자 이름으로 n 명 조회
  @Query("SELECT u FROM User u WHERE u.username = :username")
  // - User: entity 이름
  // - @Param: 해당 어노테이션을 이용해 파라미터 바인딩
  List<UserEntity> findByUsername(@Param("username") String username);

  // 2. 검색어 보냈을 때 사용자 이름/이메일에 특정 문자열이 포함된 모든 사용자 n명 찾기
  @Query("SELECT u FROM User u WHERE u.username LIKE %:keyword% OR u.email LIKE %:keyword%")
  List<UserEntity> findByUsernameContainingOrEmailContaining(@Param("keyword") String keyword);

  // 3. 이름이 존재하는지 확인
  boolean existsByUsername(String username);
}