package org.shark.crud.service;

import lombok.RequiredArgsConstructor;
import org.shark.crud.model.dto.UserDTO;
import org.springframework.stereotype.Service;

public interface UserService {
    UserDTO login(UserDTO userDto);

    UserDTO findUserByNickname(String nickname);

    boolean signUp(UserDTO user);

    UserDTO findUserByEmail(String email);
}
