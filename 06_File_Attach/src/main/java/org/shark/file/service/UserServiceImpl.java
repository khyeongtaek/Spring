package org.shark.file.service;

import lombok.RequiredArgsConstructor;
import org.shark.file.model.dto.UserDTO;
import org.shark.file.repository.UserDAO;
import org.shark.file.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final FileUtil fileUtil;

    // file.properties에 설정한 파일 저장 루트 경로 주입
    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public List<UserDTO> findAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public UserDTO findUserById(Integer uid) {
        return userDAO.getUserById(uid);
    }

    @Override
    public boolean signUp(UserDTO user, MultipartFile profile) {

        try {
            String datePath = fileUtil.getFilePath();
            Path fullSavePath = Paths.get(uploadPath, datePath);
            if (!Files.exists(fullSavePath)) {
                Files.createDirectories(fullSavePath);
            }

            String originalFilename = profile.getOriginalFilename();
            String filesystemName = fileUtil.getFilesystemName(originalFilename);
            Path filePath = fullSavePath.resolve(filesystemName);

            profile.transferTo(filePath.toFile());

            user.setFilePath(datePath);
            user.setOriginalFilename(originalFilename);
            user.setFilesystemName(filesystemName);
            return userDAO.insertUser(user) == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}