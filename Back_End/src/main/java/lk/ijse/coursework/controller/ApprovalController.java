package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.ApprovalDto;
import lk.ijse.coursework.dto.BookingDto;
import lk.ijse.coursework.entity.Approval;
import lk.ijse.coursework.service.ApprovalService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/approval")
@CrossOrigin
public class ApprovalController {

    @Autowired
    ApprovalService service;
    @GetMapping
    public String setId(){
       // System.out.println("getWorking"+service.createBookingId());
        return service.createApprovalId();
    }
    @PostMapping
    public ResponseEntity addUser(@RequestBody ApprovalDto dto) {
        service.addApproval(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping(path="/getall")
    public ResponseEntity getAllRequests() {
        List<ApprovalDto> allRequests = service.getAllBooking();
        return new ResponseEntity(new StandradResponse (200, "Success", allRequests), HttpStatus.OK);
    }
    @DeleteMapping(params = {"rid"})
    public ResponseEntity deleteUser(@RequestParam String bid) {
        service.deleteApproval(bid);
        return new ResponseEntity(new StandradResponse (200, "Success", null), HttpStatus.CREATED);
    }
    @GetMapping(path = "/{rid}")
    public ResponseEntity searchVehicle(@PathVariable String id) {
        ApprovalDto requestDTO = service.searchApprovalById(id);
        return new ResponseEntity(new StandradResponse (200, "Success", requestDTO), HttpStatus.OK);
    }
}
