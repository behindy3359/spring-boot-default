package com.example.spring_boot_mybatis.mapper;

import com.example.spring_boot_mybatis.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
  // case1. 어노테이션 기반 매퍼
  @Select("SELECT * FROM users")
  List<User> findAll();

  @Select("SELECT * FROM users where id = #{id}")
  User findOne(Long id);

  @Insert("insert into users (username, email) values (#{username},#{email})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void cUser(User user);

  @Update("update users set username = #{username}, email = #{email} where id = #{id}")
  void uUser(User user);

  @Delete("delete FROM users where id = #{id}")
  void dUser(Long id);

  /*
   case2. XML 기반 매퍼
    List<User> findAll();
    User findOne(Long id);

    void cUser(User user);

    void dUser(Long id);

    void uUser(User user);
  */
}