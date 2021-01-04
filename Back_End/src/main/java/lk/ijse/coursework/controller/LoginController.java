package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.LoginDto;
import lk.ijse.coursework.dto.UserDto;
import lk.ijse.coursework.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public UserDto getAccess(@RequestBody LoginDto dto){
        System.out.println(dto.getUsername()+""+dto.getPassword());
        return service.getAccess(dto);
    }
}
