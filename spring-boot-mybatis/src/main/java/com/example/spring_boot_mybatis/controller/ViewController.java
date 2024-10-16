package com.example.spring_boot_mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

  @GetMapping("/")
  public String redirectToUsers() {
    return "redirect:/users";
  }

  @GetMapping("/users")
  public String listUsers() {
    return "userList";
  }

  @GetMapping("/users/new")
  public String newUserForm(){
    return "userForm";
  }

  @GetMapping("/users/{id}/edit")
  public String updateUserForm(){
    return "userForm";
  }
}