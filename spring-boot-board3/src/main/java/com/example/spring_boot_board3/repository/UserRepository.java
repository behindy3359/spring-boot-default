package com.example.spring_boot_board3.repository;

import com.example.spring_boot_board3.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

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
