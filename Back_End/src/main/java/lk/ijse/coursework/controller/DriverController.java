package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.DriverDto;
import lk.ijse.coursework.service.DriverService;
import lk.ijse.coursework.service.IdGenerateService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;

@RestController
@RequestMapping("/api/v1/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    IdGenerateService generateService;

    @Autowired
    DriverService service;
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity addDriver(@RequestBody DriverDto dto) {
        System.out.println(dto.getId());
        service.saveDriver(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping(path = "/getall")
    public ResponseEntity getAllUsers() {
        List<DriverDto> allDrivers = service.getAllDrivers();
        return new ResponseEntity(new StandradResponse(200, "Success", allDrivers), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity updateDriver(@RequestBody DriverDto dto) {
        service.updateDriver(dto);
        return new ResponseEntity(new StandradResponse(200, "Success", null), HttpStatus.OK);
    }
    @GetMapping(path = "/update/{driverid}")
    public ResponseEntity updateDriverStatus(@PathVariable String driverid) {

        DriverDto dto = service.searchDriverById(driverid);
        dto.setStatus(1);
        System.out.println("driver update--"+dto.getStatus());
        service.updateDriver(dto);
        return new ResponseEntity(new StandradResponse(200, "Success", null), HttpStatus.OK);
    }
    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteDriver(@RequestParam String id) {
        service.deleteDriver(id);
        return new ResponseEntity(new StandradResponse(200, "Success", null), HttpStatus.CREATED);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity searchDriverById(@PathVariable String id) {
        System.out.println("mek wada karmme");
        DriverDto driverDTO = service.searchDriverById(id);
        return new ResponseEntity(new StandradResponse(200, "Success", driverDTO), HttpStatus.OK);
    }
    @GetMapping(path = "/getOnLogin/{username}")
    public ResponseEntity searchAdminByUsername(@PathVariable String username) {
        System.out.println(username);
        DriverDto driverDTO = service.searchDriverByUsername(username);
        return new ResponseEntity(new StandradResponse(200, "Success", driverDTO), HttpStatus.OK);
    }
    @GetMapping(params = {"id","password"})
    public ResponseEntity searchDriverByIdandPass(String id,String password) {
        DriverDto driverDTO = service.searchDriverByIdAndPass(id, password);
        return new ResponseEntity(new StandradResponse(200, "Success", driverDTO), HttpStatus.OK);
    }
    @GetMapping
    public String setId(){
        System.out.println("getWorking"+generateService.genarateId("D"));
        return generateService.genarateId("D");
    }
    @GetMapping(path = "/getallFreedriver")
    public ResponseEntity getAllfreeDriver() {
        List<DriverDto> allDrivers = service.getAllfreeDrivers();
        return new ResponseEntity(new StandradResponse(200, "Success", allDrivers), HttpStatus.OK);
    }
}
