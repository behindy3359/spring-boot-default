package com.example.spring_security.service;

import com.example.spring_security.entity.TodoEntity;
import com.example.spring_security.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
// simple loggind facade for java
// - 로그 라이브러리, 용도에 따라서 info, debug, warn, error 나눠서 로깅
// - 로깅하고 싶은 클래스에 해당 어노테이션을 작성하면 사용 가능
public class TodoService {

  @Autowired
  private TodoRepository repository;

  //create Todo
  public List<TodoEntity> createTodo(final TodoEntity entity){
    validate(entity);
    repository.save(entity);
    log.info("Entity Id : {} is saved", entity.getId());

    return repository.findByUserId(entity.getUserId()); // 추가한 행을 바로 다시 보여주기
  }

  public List<TodoEntity> readTodo( final String user ){
    return repository.findByUserId(user);
  }

  // 유효성 검사
  private void validate(final TodoEntity entity){
    if(entity == null){
      log.warn("Entity cannot be null");
      throw new RuntimeException("Entity cannot be null");
    }
    if(entity.getUserId() == null){
      log.warn("Unknown User");
      throw new RuntimeException("Unknown User");
    }
  }
}
