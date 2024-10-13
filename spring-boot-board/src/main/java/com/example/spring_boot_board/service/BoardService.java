package com.example.spring_boot_board.service;

import com.example.spring_boot_board.domain.Board;
import com.example.spring_boot_board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

  @Autowired
  private BoardMapper boardMapper;

  public void createBoard(Board board) {
    boardMapper.createBoard(board);
  }

  public Board readBoard(int id) {
    return boardMapper.readBoard(id);
  }

  public void updateBoard(Board board) {
    boardMapper.updateBoard(board);
  }

  public void deleteBoard(int id) {
    boardMapper.deleteBoard(id);
  }

  public List<Board> getAllBoards(String writer) {
    return boardMapper.getAllBoards(writer);
  }
}