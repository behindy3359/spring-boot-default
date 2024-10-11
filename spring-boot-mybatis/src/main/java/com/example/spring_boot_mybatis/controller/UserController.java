package com.example.spring_boot_mybatis.controller;

import com.example.spring_boot_mybatis.dto.UserDTO;
import com.example.spring_boot_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // restful 웹 서비스의 컨트롤러
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping
  public List<UserDTO> listUsers(){
    return userService.getAllUsers();
  }


}
