package com.example.spring_boot_mybatis.controller;

import com.example.spring_boot_mybatis.domain.User;
import com.example.spring_boot_mybatis.dto.UserDTO;
import com.example.spring_boot_mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/{id}")
  public UserDTO getUser(@PathVariable Long id){
    return userService.getUser(id);
  }

  @PostMapping
  public UserDTO cUser(@RequestBody UserDTO dto){
    userService.cUser(dto);
    return dto;
  }

  @PutMapping("/{id}")
  public UserDTO uUser(@PathVariable Long id, @RequestBody UserDTO dto){
    dto.setId(id);
    userService.uUser(dto);
    return dto;
  }


  @DeleteMapping("/{id}")
  public void dUser(@PathVariable Long id){
    userService.dUser(id);
  }
}
