package com.example.spring_boot_board2.controller;

import com.example.spring_boot_board2.dto.BoardDTO;
import com.example.spring_boot_board2.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

  @Autowired
  private BoardService BoardService;

  @GetMapping
  public List<BoardDTO> listBoards(){
    return BoardService.getAllBoards();
  }

  @GetMapping("/{id}")
  public BoardDTO getBoard(@PathVariable Long id){
    return BoardService.getBoard(id);
  }

  @PostMapping
  public BoardDTO cBoard(@RequestBody BoardDTO dto){
    BoardService.cBoard(dto);
    return dto;
  }

  @PutMapping("/{id}")
  public BoardDTO uBoard(@PathVariable Long id, @RequestBody BoardDTO dto){
    dto.setId(id);
    BoardService.uBoard(dto);
    return dto;
  }


  @DeleteMapping("/{id}")
  public void dBoard(@PathVariable Long id){
    BoardService.dBoard(id);
  }
}
