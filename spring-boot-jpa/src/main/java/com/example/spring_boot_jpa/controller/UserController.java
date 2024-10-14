package com.example.spring_boot_jpa.controller;

import com.example.spring_boot_jpa.dto.UserDTO;
import com.example.spring_boot_jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;
  @GetMapping
  public List<UserDTO> listUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("{id}")
  public UserDTO getUser(@PathVariable Long id){
    return userService.getUserById(id);
  }
}