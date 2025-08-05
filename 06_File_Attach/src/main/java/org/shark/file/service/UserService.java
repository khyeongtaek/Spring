package org.shark.file.service;

import org.shark.file.model.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();
    UserDTO findUserById(Integer uid);
    boolean signUp(UserDTO user, MultipartFile profile);
}
