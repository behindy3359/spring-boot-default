package com.example.spring_security.dto;

import com.example.spring_security.entity.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {
  private Long id;
  private String title;
  private boolean done;

  // TodoEntity 를 받아 DTO 객체로 변환하는 생성자
  public TodoDTO(final TodoEntity entity){
    this.id = entity.getId();
    this.title = entity.getTitle();
    this.done = entity.isDone();
  }

  // DTO 를 Entity로 변환하는 메소드
  public static TodoEntity toEntity(final TodoDTO dto){
    return TodoEntity.builder()
        .id(dto.getId())
        .title(dto.getTitle())
        .done(dto.isDone())
        .build();
  }
}
