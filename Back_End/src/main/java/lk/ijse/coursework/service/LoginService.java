package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.LoginDto;
import lk.ijse.coursework.dto.UserDto;

public interface LoginService {
    UserDto getAccess(LoginDto dto);
}
