package com.example.spring_boot_board3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

  @GetMapping("/")
  public String redirectToUsers() {
    return "redirect:/mains";
  }

  @GetMapping("/mains")
  public String listUsers() {
    return "mainList";
  }

  @GetMapping("/users/new")
  public String newUserForm(){
    return "userForm";
  }

  @GetMapping("/board/new")
  public String newBoardForm(){
    return "boardForm";
  }

  @GetMapping("/users/{id}/edit")
  public String updateUserForm(){
    return "userForm";
  }

  @GetMapping("/board/{id}/edit")
  public String updateBoardForm(){
    return "userForm";
  }
}