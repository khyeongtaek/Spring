package org.shark.crud.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shark.crud.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "file:src/main/webapp/WEB-INF/spring/root-context.xml"
        , "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})

public class UserDAOUnitTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testGetUser() {
//        assertNotNull(userDAO.getUser(new UserDTO(0,"shark@gmail.com","shark",null)));
    }
}