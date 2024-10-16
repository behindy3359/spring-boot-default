package com.example.spring_boot_board3.service;

import com.example.spring_boot_board3.dto.UserDTO;
import com.example.spring_boot_board3.entity.UserEntity;
import com.example.spring_boot_board3.repository.UserRepository;
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

  public void createUser(UserDTO dto){
    UserEntity user = convertToEntity(dto);
    userRepository.save(user);
  }

  public void updateUser(UserDTO dto, Long id){
    UserEntity user = convertToEntityWithId(dto, id);
    userRepository.save(user);
  }

  public void deleteUser(Long id){
    userRepository.deleteById(id);
  }

  // 1. 사용자 이름으로 n 명 조회
  public List<UserDTO> getUserByUsername(String username) {
    List<UserEntity> users = userRepository.findByUsername(username);
    List<UserDTO> userDTOs = new ArrayList<>();

    for (UserEntity user:users) {
      userDTOs.add(convertToDto(user));
    }

    return userDTOs;
  }

  public List<UserDTO> searchUsers(String keyword) {
    List<UserEntity> users = userRepository.findByUsernameContainingOrEmailContaining(keyword);
    List<UserDTO> userDTOs = new ArrayList<>();

    for (UserEntity user:users) {
      userDTOs.add(convertToDto(user));
    }

    return userDTOs;
  }

  public boolean existsByUsername(String username) {
    return userRepository.existsByUsername(username);
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

  // User to UserDTO
  private UserEntity convertToEntity(UserDTO dto) {

    return UserEntity.builder()
        .id(dto.getId())
        .username(dto.getUsername())
        .email(dto.getEmail())
        .build();
  }

  private UserEntity convertToEntityWithId(UserDTO dto, Long id){

    return UserEntity.builder()
        .id(id)
        .username(dto.getUsername())
        .email(dto.getEmail())
        .build();
  }
}
