package com.example.spring_boot_board.controller;

import com.example.spring_boot_board.domain.Board;
import com.example.spring_boot_board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

  @Autowired
  private BoardService boardService;

  @GetMapping("/")
  public String redirectToBoards() {
    return "redirect:/boards";
  }

  @GetMapping("/boards")
  public String listBoards(Model model) {
    model.addAttribute("boards", boardService.getAllBoards(null));
    return "boardList";
  }

  @GetMapping("/boards/new")
  public String newBoardForm(Model model) {
    model.addAttribute("board", new Board());
    return "boardForm";
  }

  @GetMapping("/boards/{id}/edit")
  public String editBoardForm(@PathVariable int id, Model model) {
    Board board = boardService.readBoard(id);
    model.addAttribute("board", board);
    return "boardForm";  // 기존의 boardForm을 재사용할 수 있습니다.
  }

  @PostMapping("/boards/{id}/edit")
  public String updateBoard(@PathVariable int id, @ModelAttribute Board board) {
    board.setId(id);
    boardService.updateBoard(board);
    return "redirect:/boards/" + id;
  }

  @GetMapping("/boards/{id}/delete")
  public String deleteBoard(@PathVariable int id) {
    boardService.deleteBoard(id);
    return "redirect:/boards";
  }

  @GetMapping("/boards/{id}")
  public String viewBoard(@PathVariable int id, Model model) {
    Board board = boardService.readBoard(id);
    model.addAttribute("board", board);
    return "boardView";
  }
}