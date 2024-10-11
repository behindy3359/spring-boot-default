package com.example.spring_boot_mybatis.service;

import com.example.spring_boot_mybatis.domain.User;
import com.example.spring_boot_mybatis.dto.UserDTO;
import com.example.spring_boot_mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserMapper userMapper;

  public List<UserDTO> getAllUsers(){
    List<User> users = userMapper.findAll();

    List<UserDTO> dtos = new ArrayList<>();

    for(User user : users){
      UserDTO dto = convertToDto(user);
      dtos.add(dto);
    }
    return dtos;
  }

  private UserDTO convertToDto(User user){
    UserDTO dto = new UserDTO();

    dto.setId(user.getId());
    dto.setEmail(user.getEmail());
    dto.setUsername(user.getUsername());
    dto.setNo((int)(user.getId() + 100));

    return dto;
  }
}
