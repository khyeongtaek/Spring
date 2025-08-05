package org.shark.crud.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.shark.crud.model.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final SqlSessionTemplate template;

    public UserDTO getUserByEmailAndPassword(UserDTO userDto) {
        return template.selectOne(prependNamespace("getUserByEmailAndPassword"), userDto);
    }

    public UserDTO getUserByNickname(String nickname) {
        return template.selectOne(prependNamespace("getUserByNickname"), nickname);
    }

    public int insertUser(UserDTO user){
        return template.insert(prependNamespace("insertUser"), user);
    }

    public UserDTO getUserByEmail(String email) {
        return template.selectOne(prependNamespace("getUserByEmail"), email);
    }


    private String prependNamespace(String statementId) {
        return "mybatis.mapper.userMapper." + statementId;
    }


}
