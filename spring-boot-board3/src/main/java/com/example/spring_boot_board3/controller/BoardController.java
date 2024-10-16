package com.example.spring_boot_board3.controller;

import com.example.spring_boot_board3.dto.BoardDTO;
import com.example.spring_boot_board3.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

  @Autowired
  private BoardService boardService;

  @GetMapping
  public List<BoardDTO> listBoards(){
    return boardService.getAllBoards();
  }

  @GetMapping("{id")
  public BoardDTO getBoard(@PathVariable Long id ){return boardService.getBoardById(id);}

  @PostMapping
  public BoardDTO createBoard(@RequestBody BoardDTO dto){
    boardService.createBoard(dto);
    return dto;
  }

  @PutMapping("/{id}")
  public void updateBoard(@PathVariable Long id, @RequestBody BoardDTO dto){boardService.updateBoard(dto, id);}

  @DeleteMapping("/{id}")
  public void deleteBoard(@PathVariable Long id){boardService.deleteBoard(id);}
}
