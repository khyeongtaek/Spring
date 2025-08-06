package org.shark.file.service;

import lombok.RequiredArgsConstructor;
import org.shark.file.model.dto.AttachDTO;
import org.shark.file.model.dto.NoticeDTO;
import org.shark.file.repository.NoticeDAO;
import org.shark.file.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeServiceImpl implements NoticeService {
    private final NoticeDAO noticeDAO;
    private final FileUtil fileUtil;

    // file.properties에 설정한 파일 저장 루트 경로 주입
    @Value("${upload.path}")
    private String uploadPath;

    @Transactional(readOnly = true)
    @Override
    public List<NoticeDTO> findNotices() {
        return noticeDAO.getNotices();
    }

    @Transactional(readOnly = true)
    @Override
    public Map<String, Object> findNoticeById(Integer nid) {
        return Map.of("notice", noticeDAO.getNoticeById(nid), "attaches", noticeDAO.getAttaches(nid));
    }

    @Override
    public boolean addNotice(NoticeDTO noticeDTO, List<MultipartFile> fileList) {

        try {
            System.out.println("공지사항 등록 이전 nid: " + noticeDTO.getNid());
            int addedNoticeCount = noticeDAO.insertNotice(noticeDTO);
            System.out.println("공지사항 등록 이후 nid: " + noticeDTO.getNid());
            if (addedNoticeCount == 1) {
                for (MultipartFile file : fileList) {
                    if (!file.isEmpty()) {
                        String datePath = fileUtil.getFilePath();
                        Path path = Paths.get(uploadPath, datePath);
                        if(!Files.notExists(path)){
                            Files.createDirectories(path);
                        }
                        String originalFilename = file.getOriginalFilename();
                        String filesystemName = fileUtil.getFilesystemName(originalFilename);

                        file.transferTo(Paths.get(uploadPath, datePath, filesystemName).toFile());
                        AttachDTO attachDTO = AttachDTO.builder()
                                .nid(noticeDTO.getNid())
                                .filePath(datePath)
                                .originalFilename(originalFilename)
                                .filesystemName(filesystemName)
                                .build();
                        noticeDAO.insertAttach(attachDTO);
                    }
                }

                return true;
            } else {
                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteNoticeById(Integer nid) {
        List<AttachDTO> attaches = noticeDAO.getAttaches(nid);
        // 첨부 목록 참조해서 서버에 저장된 첨부 파일들 삭제

        attaches.stream()
                .map(attach -> new File(uploadPath + attach.getFilePath() + "/" + attach.getFilesystemName()))
                .filter(File::exists)
                .forEach(file -> {
                    boolean deleted = file.delete();
                    if (!deleted) {
                        System.out.println("==========파삭실=========");
                        System.out.println("file.getAbsolutePath():" + file.getAbsolutePath());
                        System.out.println("file.getPath():" + file.getPath());
                    }
                });

        /*
        attaches.forEach(attach -> {

            String filePath = uploadPath + attach.getFilePath() + "/" + attach.getFilesystemName();
            File file = new File(filePath);
            if (file.exists()) {
                boolean deleted = file.delete();
                if (!deleted) {
                    System.out.println("==========파삭실=========");
                    System.out.println("filePath:"+ filePath);
                }
            }
        });
         */

        return noticeDAO.deleteNoticeById(nid) == 1;

    }

    @Transactional(readOnly = true)
    @Override
    public AttachDTO findAttachById(Integer aid) {
        return  noticeDAO.getAttachById(aid);
    }

    @Override
    public Resource loadAttachAsResource(AttachDTO attachDTO) {
        return new FileSystemResource(Paths.get(uploadPath, attachDTO.getFilePath(), attachDTO.getFilesystemName()).toFile());
    }
}
