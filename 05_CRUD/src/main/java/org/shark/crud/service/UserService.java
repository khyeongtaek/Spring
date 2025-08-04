package org.shark.crud.service;

import lombok.RequiredArgsConstructor;
import org.shark.crud.model.dto.UserDTO;
import org.springframework.stereotype.Service;

public interface UserService {
    UserDTO findUserByEmailAndPassword(UserDTO userDto);
    UserDTO findUserByNickname(String nickname);
}
