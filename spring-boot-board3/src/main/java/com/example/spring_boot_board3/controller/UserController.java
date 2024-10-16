package com.example.spring_boot_board3.controller;

import com.example.spring_boot_board3.dto.UserDTO;
import com.example.spring_boot_board3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  // 입력값에 대한 검증은 관례적으로 컨트롤러에서 수행
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

  @PostMapping
  public UserDTO createUser(@RequestBody UserDTO dto){
    userService.createUser(dto);
    return dto;
  }

  @PutMapping("/{id}")
  public void updateUser(@PathVariable Long id, @RequestBody UserDTO dto){
    userService.updateUser(dto, id);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id){
    userService.deleteUser(id);
  }

  @GetMapping("/byUsername")
  public List<UserDTO> getUserByUsername(@RequestParam String username) {
    return userService.getUserByUsername(username);
  }

  @GetMapping("/search")
  public List<UserDTO> searchUsers(@RequestParam String keyword){
    return userService.searchUsers(keyword);
  }

  @GetMapping("/exists")
  public boolean existsUser(@RequestParam String username){
    return userService.existsByUsername(username);
  }
}