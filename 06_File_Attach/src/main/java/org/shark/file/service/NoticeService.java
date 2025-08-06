package org.shark.file.service;

import org.shark.file.model.dto.AttachDTO;
import org.shark.file.model.dto.NoticeDTO;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    List<NoticeDTO> findNotices();
    Map<String, Object> findNoticeById(Integer nid);
    boolean addNotice(NoticeDTO noticeDTO, List<MultipartFile> attachFile);
    boolean deleteNoticeById(Integer nid);
    AttachDTO findAttachById(Integer aid);

    Resource loadAttachAsResource(AttachDTO attachDTO);

}
