package com.example.spring_security.repository;

import com.example.spring_security.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
  List<TodoEntity> findByUserId(String userId);
}
