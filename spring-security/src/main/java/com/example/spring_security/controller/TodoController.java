package com.example.spring_security.controller;

import com.example.spring_security.dto.ResponseDTO;
import com.example.spring_security.dto.TodoDTO;
import com.example.spring_security.entity.TodoEntity;
import com.example.spring_security.security.TokenProvider;
import com.example.spring_security.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/todo")
public class TodoController {
  @Autowired
  private TodoService service;

  @Autowired
  private TokenProvider tokenProvider;


  @PostMapping
  public ResponseEntity<?> createTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto){
    try{
      // 임시 코드, 유저정보를 하드코딩 한 상태
//      String temporaryUserInfoId = "tempId" ;

      TodoEntity entity = TodoDTO.toEntity(dto);

      entity.setId(null);

      entity.setUserId(userId);

      List<TodoEntity> entities = service.createTodo(entity);

      List<TodoDTO> dtos = new ArrayList<>();
      for (TodoEntity e :entities){
        TodoDTO tempDTO = new TodoDTO(e);
        dtos.add(tempDTO);
      }

      ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

      return ResponseEntity.ok().body(response);

    } catch (Exception err){
      String error = err.getMessage();
      ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
      return ResponseEntity.ok().body(response);
    }
  }

  @GetMapping
  public ResponseEntity<?> readTodo(@AuthenticationPrincipal String userid){

    List<TodoEntity> entities = service.readTodo(userid);

    List<TodoDTO> dtos = new ArrayList<>();
    for (TodoEntity e : entities){
      TodoDTO tempDTO = new TodoDTO(e);
      dtos.add(tempDTO);
    }

    ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

    return ResponseEntity.ok().body(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteTodo(@AuthenticationPrincipal String userId, @PathVariable Long id) {
    try {
      service.deleteTodo(id);

      List<TodoEntity> entities = service.readTodo(userId);

      List<TodoDTO> dtos = new ArrayList<>();
      for (TodoEntity e : entities){
        TodoDTO tempDTO = new TodoDTO(e);
        dtos.add(tempDTO);
      }

      ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

      return ResponseEntity.ok().body(response);
    } catch (Exception err) {
      String error = err.getMessage();
      ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
      return ResponseEntity.ok().body(response);
    }
  }

  @PutMapping
  public ResponseEntity<?> updateTodo(@AuthenticationPrincipal String userId, @RequestBody TodoDTO dto){
    try{
      // 임시 코드, 유저정보를 하드코딩 한 상태
//      String temporaryUserInfoId = "tempId" ;

      TodoEntity entity = TodoDTO.toEntity(dto);

      entity.setId(dto.getId());

      entity.setUserId(userId);

      List<TodoEntity> entities = service.createTodo(entity);

      List<TodoDTO> dtos = new ArrayList<>();
      for (TodoEntity e :entities){
        TodoDTO tempDTO = new TodoDTO(e);
        dtos.add(tempDTO);
      }

      ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

      return ResponseEntity.ok().body(response);

    } catch (Exception err){
      String error = err.getMessage();
      ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
      return ResponseEntity.ok().body(response);
    }
  }
}
