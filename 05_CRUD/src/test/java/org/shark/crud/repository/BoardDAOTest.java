package org.shark.crud.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shark.crud.model.dto.BoardDTO;
import org.shark.crud.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
        , "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
public class BoardDAOTest {
    @Autowired
    private BoardDAO boardDAO;

    @Test
    public void getBoardList() {
        assertEquals("나는 호랑이", boardDAO.getBoards().get(3).getTitle());
    }


    @Test
    public void 신규등록_테슽() {
        UserDTO user = UserDTO.builder()
                .uid(3)
                .build();
        BoardDTO board = BoardDTO.builder()
                .title("테스트죄목")
                .content("테슽흐내용")
                .user(user)
                .build();
        assertEquals(1, boardDAO.insertBoard(board));
    }

}