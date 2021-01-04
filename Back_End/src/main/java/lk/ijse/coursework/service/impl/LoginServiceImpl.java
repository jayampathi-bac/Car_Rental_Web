package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.LoginDto;
import lk.ijse.coursework.dto.UserDto;
import lk.ijse.coursework.service.LoginService;
import lk.ijse.coursework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserService service;


    @Override
    public UserDto getAccess(LoginDto dto) {
        UserDto to = service.searchUserbyUserName(dto.getUsername());
        System.out.println("-----acc"+to.getPassword()+"----"+to.getUsername());
        System.out.println(to.getStatus());
        System.out.println(to.getPassword().equalsIgnoreCase(dto.getPassword()));
        if(to==null){

        }else if(to.getPassword().equalsIgnoreCase(dto.getPassword())){
            System.out.println("--stsus--"+to.getStatus());
            return to;
        }
        return null;
    }
}
