package com.example.spring_boot_jpa.service;

import com.example.spring_boot_jpa.dto.UserDTO;
import com.example.spring_boot_jpa.entity.UserEntity;
import com.example.spring_boot_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<UserDTO> getAllUsers() {
    List<UserEntity> users = userRepository.findAll();
    List<UserDTO> userDTOs = new ArrayList<>();

    for (UserEntity user : users) {
      UserDTO userDTO = convertToDto(user);
      userDTOs.add(userDTO);
    }

    return userDTOs;
  }

  public UserDTO getUserById(Long id){
    UserEntity user = userRepository.findById(id).orElse(null );

    if(user == null){
      throw new RuntimeException("User not found");
    }

    return convertToDto(user);
  }

  public void createUser(UserEntity user){
    userRepository.save(user);
  }

//  public void updateUser(UserEntity user, Long id){
//    UserEntity = userRepository.findById(id);
//  }

  public void deleteUser(Long id){
    userRepository.deleteById(id);
  }


  // User to UserDTO
  private UserDTO convertToDto(UserEntity user) {

    return UserDTO.builder()
        .id(user.getId())
        .username(user.getUsername())
        .email(user.getEmail())
        .no((int)( user.getId() + 100))
        .build();
  }
}
