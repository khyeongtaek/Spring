package org.shark.crud.service;

import lombok.RequiredArgsConstructor;
import org.shark.crud.model.dto.BoardDTO;
import org.shark.crud.repository.BoardDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardDAO boardDAO;
    @Override
    public List<BoardDTO> findAllBoards() {
        return boardDAO.getBoards();
    }

    @Override
    public BoardDTO findBoardById(Integer bid) {
        return boardDAO.getBoardById(bid);
    }

    @Override
    public boolean addBoard(BoardDTO board) {
        return boardDAO.insertBoard(board) == 1;
    }

    @Override
    public boolean modifyBoard(BoardDTO board) {
        return boardDAO.updateBoard(board) == 1;
    }

    @Override
    public boolean removeBoard(Integer bid) {
        return boardDAO.deleteBoard(bid) == 1;
    }
}
