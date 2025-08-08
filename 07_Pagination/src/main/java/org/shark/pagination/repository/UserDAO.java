package org.shark.pagination.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.shark.pagination.model.dto.PageDTO;
import org.shark.pagination.model.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final SqlSessionTemplate sqlSessionTemplate;

    public List<UserDTO> getUsers(Map<String, Object> map){
        return sqlSessionTemplate.selectList(nameSpace(), map);
    }

    public Integer getUserCount(){
        return sqlSessionTemplate.selectOne(nameSpace());
    }



    private String nameSpace() {
        String methodName = Thread.currentThread()
                .getStackTrace()[2]
                .getMethodName();
        return "mybatis.mapper.userMapper." + methodName;
    }
}
