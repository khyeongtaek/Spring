package org.shark.file.service;

import lombok.RequiredArgsConstructor;
import org.shark.file.model.dto.UserDTO;
import org.shark.file.repository.UserDAO;
import org.shark.file.util.FileUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final FileUtil fileUtil;

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
            String filePath = fileUtil.getFilePath();
            Path uploadPath = Paths.get(filePath);
            System.out.println("=========서비스=================");
            System.out.println();
            System.out.println();
            System.out.println("uploadPath: "+ uploadPath);
            System.out.println();
            System.out.println();
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String originalFilename = profile.getOriginalFilename();
            String filesystemName = fileUtil.getFilesystemName(originalFilename);

            Path path = Paths.get(filePath + "/" + filesystemName);
            Files.copy(profile.getInputStream(), path);

            user.setFilePath(filePath);
            user.setOriginalFilename(originalFilename);
            user.setFilesystemName(filesystemName);
            return userDAO.insertUser(user) == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
