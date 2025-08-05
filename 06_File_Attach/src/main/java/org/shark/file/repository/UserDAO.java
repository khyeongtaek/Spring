package org.shark.file.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.shark.file.model.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final SqlSessionTemplate sqlSessionTemplate;

    private String nameSpace(String statement){
        return "mybatis.mapper.userMapper."+statement;
    }

    public List<UserDTO> getAllUsers() {
        return sqlSessionTemplate.selectList(nameSpace("getAllUsers"));
    }

    public UserDTO getUserById(Integer uid) {
        return sqlSessionTemplate.selectOne(nameSpace("getUserById"), uid);
    }
    
    public int insertUser(UserDTO user) {
        return sqlSessionTemplate.insert(nameSpace("insertUser"), user);
    }




}
