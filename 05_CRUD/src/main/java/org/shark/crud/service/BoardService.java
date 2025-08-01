package org.shark.crud.service;

import org.shark.crud.model.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> findAllBoards();
    BoardDTO findBoardById(Integer bid);
    boolean addBoard(BoardDTO board);
    boolean modifyBoard(BoardDTO board);
    boolean removeBoard(Integer bid);
}
