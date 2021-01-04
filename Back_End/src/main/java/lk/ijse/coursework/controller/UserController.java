package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.CustomerDto;
import lk.ijse.coursework.dto.UserDto;
import lk.ijse.coursework.service.UserService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.security.util.Password;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(params = {"Username","Password"})
    public ResponseEntity searchUser(String Username, String Password) {
        String msg=null;
        UserDto user = userService.searchUserbyUserName(Username);
        if(user.getPassword().equalsIgnoreCase(Password)){
            msg="valid";
        }else{
            msg="invalid";
        }

        return new ResponseEntity(new StandradResponse(200, msg, null), HttpStatus.OK);
    }
//    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity addUser(@RequestBody CustomerDTO dto) {
//        customerService.saveCustomer(dto);
//        StandradResponse response = new StandradResponse(200, "Success", null);
//        return new ResponseEntity(response, HttpStatus.CREATED);
//    }
  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addUser(@RequestBody UserDto dto) {
        userService.saveUser(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
    return new ResponseEntity(response, HttpStatus.CREATED);
}

}
