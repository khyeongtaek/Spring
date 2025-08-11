package org.shark.hierarchy.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.shark.hierarchy.model.dto.BbsDTO;
import org.shark.hierarchy.model.dto.PageDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BbsDAO {
    private final SqlSessionTemplate sqlSessionTemplate;


    public int insertParentBbs(BbsDTO bbsDTO) {
        return sqlSessionTemplate.insert(nameSpace(), bbsDTO);
    }

    public int updateGroupId(BbsDTO bbsDTO) {
        return sqlSessionTemplate.update(nameSpace(), bbsDTO);
    }

    public int updateGroupOrder(BbsDTO bbsDTO) {
        return sqlSessionTemplate.update(nameSpace(), bbsDTO);
    }

    public int insertChildBbs(BbsDTO bbsDTO) {
        return sqlSessionTemplate.insert(nameSpace(), bbsDTO);
    }

    public int deleteBbsById(Integer bbsId) {
        return sqlSessionTemplate.delete(nameSpace(), bbsId);
    }
    public Integer getBbsCount() {
        return sqlSessionTemplate.selectOne(nameSpace());
    }
    public List<BbsDTO> getBbsList(PageDTO pageDTO) {
        return sqlSessionTemplate.selectList(nameSpace(), pageDTO);
    }



    private String nameSpace() {
        String methodName = Thread.currentThread()
                .getStackTrace()[2]
                .getMethodName();
        return "mybatis.mapper.bbsMapper." + methodName;
    }


}
