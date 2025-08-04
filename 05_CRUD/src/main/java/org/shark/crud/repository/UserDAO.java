package org.shark.crud.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.shark.crud.model.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final SqlSessionTemplate template;

    public UserDTO getUser(UserDTO userDto) {
        return template.selectOne(prependNamespace("getUser"), userDto);
    }

    public UserDTO getUserByNickname(String nickname) {
        return template.selectOne(prependNamespace("getUserByNickname"), nickname);
    }


    private String prependNamespace(String statementId) {
        return "mybatis.mapper.userMapper." + statementId;
    }

}
