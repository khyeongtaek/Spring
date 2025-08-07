package org.shark.pagination.repository;

import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.shark.pagination.model.dto.AttachDTO;
import org.shark.pagination.model.dto.NoticeDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class NoticeDAO {
    private final SqlSessionTemplate sqlSessionTemplate;

    private String nameSpace() {
        String methodName = Thread.currentThread()
                .getStackTrace()[2]
                .getMethodName();
        return "mybatis.mapper.noticeMapper." + methodName;
    }

    public List<NoticeDTO> getNotices(){
        return sqlSessionTemplate.selectList(nameSpace());
    }

    public NoticeDTO getNoticeById(Integer nid) {
        return sqlSessionTemplate.selectOne(nameSpace(), nid);
    }

    public List<AttachDTO> getAttaches(Integer nid) {
        return sqlSessionTemplate.selectList(nameSpace(), nid);
    }

    public int insertNotice(NoticeDTO notice) {
        return sqlSessionTemplate.insert(nameSpace(), notice);
    }

    public int insertAttach(AttachDTO attach) {
        return sqlSessionTemplate.insert(nameSpace(), attach);
    }

    public int deleteNoticeById(Integer nid) {
        return sqlSessionTemplate.delete(nameSpace(), nid);
    }

    public AttachDTO getAttachById(Integer aid) {
        return sqlSessionTemplate.selectOne(nameSpace(), aid);
    }

}
