package lk.ijse.coursework.service;


import lk.ijse.coursework.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto searchUserbyUserName(String name);
    void saveUser(UserDto dto);
    void updateUser(UserDto dto);
    void deleteUser(String id);
    public List<UserDto> getAllUsers();
    String getUsernamebyId(String id);

}
