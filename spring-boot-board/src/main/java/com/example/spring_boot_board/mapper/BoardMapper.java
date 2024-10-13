package com.example.spring_boot_board.mapper;

import com.example.spring_boot_board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

  void createBoard(Board board);
  Board readBoard(int id);
  void updateBoard(Board board);
  void deleteBoard(int id);

  List<Board> getAllBoards(String writer);
}