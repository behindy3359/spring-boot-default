package com.example.spring_boot_board2.service;

import com.example.spring_boot_board2.domain.Board;
import com.example.spring_boot_board2.dto.BoardDTO;
import com.example.spring_boot_board2.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {
  @Autowired
  private BoardMapper bMapper;

  public List<BoardDTO> getAllBoards(){
    List<Board> boards = bMapper.findAllBoard();
    List<BoardDTO> dtos = new ArrayList<>();

    for(Board b : boards){
      BoardDTO dto = convertToDto(b);
      dtos.add(dto);
    }
    return dtos;
  }

  public BoardDTO getBoard( Long id ){
    Board board = bMapper.findOneBoard(id);
    return convertToDto(board);
  }

  public void cBoard( BoardDTO dto){
    Board b = convertToEntity(dto);
    bMapper.cBoard(b);
  }

  public void uBoard(BoardDTO dto){
    Board b = convertToEntity(dto);
    bMapper.uBoard(b);
  }

  public void dBoard(Long id){
    bMapper.dBoard(id);
  }

  private BoardDTO convertToDto(Board board){
    BoardDTO dto = new BoardDTO();

    dto.setId(board.getId());
    dto.setTitle(board.getTitle());
    dto.setContent(board.getContent());
    dto.setWriter(board.getWriter());
    dto.setRegistered(board.getRegistered());

    return dto;
  }

  // DTO to domain
  private Board convertToEntity(BoardDTO dto){
    Board board = new Board();
    board.setId(dto.getId());
    board.setTitle(dto.getTitle());
    board.setContent(dto.getContent());
    board.setWriter(dto.getWriter());
    board.setRegistered(dto.getRegistered());

    return board;
  }
}
