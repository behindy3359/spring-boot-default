package com.example.spring_boot_board3.service;

import com.example.spring_boot_board3.dto.BoardDTO;
import com.example.spring_boot_board3.entity.BoardEntity;
import com.example.spring_boot_board3.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

  @Autowired
  private BoardRepository boardRepository;

  public List<BoardDTO> getAllBoards() {
    List<BoardEntity> boards = boardRepository.findAll();
    List<BoardDTO> boardDTOs = new ArrayList<>();

    for (BoardEntity board : boards) {
      BoardDTO boardDTO = convertToDto(board);
      boardDTOs.add(boardDTO);
    }

    return boardDTOs;
  }

  public BoardDTO getBoardById(Long id){
    BoardEntity board = boardRepository.findById(id).orElse(null );

    if(board == null){
      throw new RuntimeException("Board not found");
    }

    return convertToDto(board);
  }

  public void createBoard(BoardDTO dto){
    BoardEntity board = convertToEntity(dto);
    boardRepository.save(board);
  }

  public void updateBoard(BoardDTO dto, Long id){
    BoardEntity board = convertToEntityWithId(dto, id);
    boardRepository.save(board);
  }

  public void deleteBoard(Long id){
    boardRepository.deleteById(id);
  }

  private BoardDTO convertToDto(BoardEntity board) {

    return BoardDTO.builder()
        .id(board.getId())
        .title(board.getTitle())
        .content(board.getContent())
        .writer(board.getWriter())
        .registered(board.getRegistered())
        .build();
  }

  // User to UserDTO
  private BoardEntity convertToEntity(BoardDTO dto) {

    return BoardEntity.builder()
        .id(dto.getId())
        .title(dto.getTitle())
        .content(dto.getContent())
        .writer(dto.getWriter())
        .build();
  }

  private BoardEntity convertToEntityWithId(BoardDTO dto, Long id){

    return BoardEntity.builder()
        .id(id)
        .title(dto.getTitle())
        .content(dto.getContent())
        .writer(dto.getWriter())
        .build();
  }
}
