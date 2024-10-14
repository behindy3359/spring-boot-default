package com.example.spring_boot_board2.mapper;

import com.example.spring_boot_board2.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

  @Select("SELECT * FROM board")
  List<Board> findAllBoard();

  @Select("SELECT * FROM board where id = #{id}")
  Board findOneBoard(Long id);

//  @Select("SELECT * FROM board where writer = #{writer}")
//  Board findByWriter(String writer);

  @Insert("INSERT INTO board (title, content, writer) values (#{title},#{content},#{writer})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void cBoard(Board board);

  @Update("Update board set title=#{title}, content=#{content} where id =#{id}")
  void uBoard(Board board);

  @Delete("DELETE FROM board WHERE id = #{id}")
  void dBoard(Long id);

}
