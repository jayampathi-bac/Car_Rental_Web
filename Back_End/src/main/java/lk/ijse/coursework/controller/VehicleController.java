package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.CustomerDto;
import lk.ijse.coursework.dto.Vehicle01Dto;
import lk.ijse.coursework.dto.VehicleDto;
import lk.ijse.coursework.service.VehicleService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    VehicleService service;
//    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity addCustomer(@RequestBody VehicleDto dto) throws IOException {
//        System.out.println(dto.getImage());
//        service.saveVehicle(dto);
//        StandradResponse response = new StandradResponse(200, "Success", null);
//        return new ResponseEntity(response, HttpStatus.CREATED);
//    }
@PostMapping
public ResponseEntity addVehicle(@RequestBody Vehicle01Dto dto) {
    service.saveVehicle(dto);
    StandradResponse response = new StandradResponse(200, "Success", null);
    return new ResponseEntity(response, HttpStatus.CREATED);
}
    @PutMapping
    public ResponseEntity updateVehicle(@RequestBody Vehicle01Dto dto) {
        service.updateVehicle(dto);
        return new ResponseEntity(new StandradResponse(200, "Success", null), HttpStatus.OK);
    }
    @DeleteMapping(params = {"id"})
    public ResponseEntity deleteVehicle(@RequestParam String id) {
        service.deleteVehicle(id);
        return new ResponseEntity(new StandradResponse(200, "Success", null), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity getAllVehicles() {
        List<Vehicle01Dto> allVehicles = service.getAllVehicles();
        return new ResponseEntity(new StandradResponse(200, "Success", allVehicles), HttpStatus.OK);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity searchVehicle(@PathVariable String id) {
        Vehicle01Dto vehicleDTO = service.searchVehicle(id);
        return new ResponseEntity(new StandradResponse(200, "Success", vehicleDTO), HttpStatus.OK);
    }

}
