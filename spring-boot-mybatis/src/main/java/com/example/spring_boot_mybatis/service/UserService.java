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

  public UserDTO getUser( Long id ){
    User user = userMapper.findOne(id);
    return convertToDto(user);
  }

  // 참고. domain.User 와 dto.UserDTO 를 서로 변환하는 이유
  // - domain.User 는 데이터베이스 엔티티를 표현( 영속성 계층과 변환 )
  // - dto.UserDTO 는 클라이언트와 데이터 전송에 사용( 표현 계층과 연관 )
  // DTO 를 사용 시 클라이언트의 요구사항에 맞춰서 데이터 구조를 쉽게 변경
  // 필요한 데이터만 클라이언트에 전송하여 네트워크 부하를 줄일 수 있음
  // API 버전관리에 용이

  public void cUser(UserDTO dto){
    User user = convertToEntity(dto);
    userMapper.cUser(user);

  }

  public void uUser(UserDTO dto){
    User user = convertToEntity(dto);
    userMapper.uUser(user);
  }

  public void dUser(Long id){
    userMapper.dUser(id);
  }



  //domain to DTO
  private UserDTO convertToDto(User user){
    UserDTO dto = new UserDTO();

    dto.setId(user.getId());
    dto.setEmail(user.getEmail());
    dto.setUsername(user.getUsername());
    dto.setNo((int)(user.getId() + 100));

    return dto;
  }

  // DTO to domain
  private User convertToEntity(UserDTO dto){
    User user = new User();
    user.setId(dto.getId());
    user.setUsername(dto.getUsername());
    user.setEmail(dto.getEmail());

    return user;
  }
}
