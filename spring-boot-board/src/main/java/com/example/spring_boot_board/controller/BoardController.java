package com.example.spring_boot_board.controller;

import com.example.spring_boot_board.domain.Board;
import com.example.spring_boot_board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

  @Autowired
  private BoardService service;

  @PostMapping
  public ResponseEntity<Void> createBoard(@RequestBody Board board) {
    service.createBoard(board);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Board> readBoard(@PathVariable int id) {
    Board board = service.readBoard(id);
    if (board != null) {
      return new ResponseEntity<>(board, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateBoard(@PathVariable int id, @RequestBody Board board) {
    board.setId(id);
    service.updateBoard(board);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteBoard(@PathVariable int id) {
    service.deleteBoard(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping
  public ResponseEntity<List<Board>> getAllBoards(String writer) {
    List<Board> boards = service.getAllBoards(writer);
    return new ResponseEntity<>(boards, HttpStatus.OK);
  }
}