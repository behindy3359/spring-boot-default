package com.example.spring_boot_mybatis.mapper;

import com.example.spring_boot_mybatis.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface UserMapper {
  // case1. 어노테이션 기반 매퍼
  //@Select("SELECT * FROM users")
//List<User> findAll();
// case2. XML 기반 매퍼
  List<User> findAll();
}