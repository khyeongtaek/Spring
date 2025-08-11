package org.shark.file.service.task;

import org.shark.file.repository.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class FileCleanupScheduler {

    // file.properties에 설정한 파일 저장 루트 경로 주입
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private NoticeDAO noticeDAO;


    @Scheduled(cron = "0 0 3 * * *")
    public void cleanupUnusedFiles() {
        // 어제 날짜의 폴더 경로 계산 하기
        LocalDate yesterday = LocalDate.now().minusDays(1);
        String dirPath = uploadPath + "/" + yesterday.format(DateTimeFormatter.ofPattern("/yyyy/MM/dd"));

        // 해당 폴더의 파일 목록 조회하기
        File dir = new File(dirPath);
        if(!dir.exists() || dir.isDirectory()) {
            return;
        }
        File[] files = dir.listFiles();
        Arrays.stream(files)
                .map(File::getName)
                .collect(Collectors.toList());

        // DB에서 해당 경로를 가진 첨부파일 목록 조회하기

        // 비교 및 삭제하기 (삭제된 파일의 로그 남기기)



    }
}
