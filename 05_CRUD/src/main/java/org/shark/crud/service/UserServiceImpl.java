package org.shark.crud.service;


import lombok.RequiredArgsConstructor;
import org.shark.crud.model.dto.UserDTO;
import org.shark.crud.repository.UserDAO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;

    @Override
    public UserDTO findUserByEmailAndPassword(UserDTO userDto) {
        return userDAO.getUser(userDto);
    }

    @Override
    public UserDTO findUserByNickname(String nickname) {
        return userDAO.getUserByNickname(nickname);
    }
}
