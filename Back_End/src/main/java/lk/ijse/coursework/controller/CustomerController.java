package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.CustomerDto;
import lk.ijse.coursework.service.CustomerService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addCustomer(@RequestBody CustomerDto dto) {
        System.out.println(dto.getIdnumber());
        service.saveCustomer(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping
    public String setId(){
        System.out.println("getWorking"+service.createCustomerId());
        return service.createCustomerId();
    }
    @GetMapping(path = "/getall")
    public ResponseEntity getAllCustomer() {
//        List<UserDTO> allUsers = service.getAllUsers();
        List<CustomerDto> allCustomers = service.getAllCustomers();
       return new ResponseEntity(new StandradResponse(200, "Success", allCustomers), HttpStatus.OK);
    }
}
