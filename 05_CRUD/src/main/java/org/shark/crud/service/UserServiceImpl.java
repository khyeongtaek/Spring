package org.shark.crud.service;


import lombok.RequiredArgsConstructor;
import org.shark.crud.model.dto.UserDTO;
import org.shark.crud.repository.UserDAO;
import org.shark.crud.util.SecureUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;
    private final SecureUtil secureUtil;


    @Override
    public UserDTO login(UserDTO user) {
        UserDTO foundUser = userDAO.getUserByEmail(user.getEmail());
        if(foundUser == null){
            return null;
        }

        return foundUser.getPassword().equals(secureUtil.hashPBKDF2(user.getPassword(), foundUser.getSalt())) ? foundUser : null;

    }

    @Override
    public UserDTO findUserByNickname(String nickname) {
        return userDAO.getUserByNickname(nickname);
    }

    @Override
    public boolean signUp(UserDTO user) {
        user.setSalt(secureUtil.getSalt());
        user.setPassword(secureUtil.hashPBKDF2(user.getPassword(), user.getSalt()));
        return userDAO.insertUser(user) == 1;
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }
}
