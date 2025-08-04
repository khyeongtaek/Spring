package org.shark.crud.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.shark.crud.model.dto.BoardDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardDAO {
    private final SqlSessionTemplate template;
    private String prependNamespace(String statementId) {
        return "mybatis.mapper.boardMapper." + statementId;
    }

    public List<BoardDTO> getBoards(){
        return template.selectList(prependNamespace("getBoards"));
    }

    public BoardDTO getBoardById(int bid){
        return template.selectOne(prependNamespace("getBoardById"), bid);
    }

    public int insertBoard(BoardDTO board){
        return template.insert(prependNamespace("insertBoard"), board);
    }

    public int updateBoard(BoardDTO board){
        return template.update(prependNamespace("updateBoard"), board);
    }

    public int deleteBoard(int bid){
        return template.delete(prependNamespace("deleteBoardById"), bid);
    }

    public Integer getBoardCount(){
        return template.selectOne(prependNamespace("getBoardCount"));
    }







}
