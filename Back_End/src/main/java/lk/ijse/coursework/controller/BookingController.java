package lk.ijse.coursework.controller;

import lk.ijse.coursework.dto.BookingDto;
import lk.ijse.coursework.service.BookingService;
import lk.ijse.coursework.util.StandradResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/booking")
@CrossOrigin
public class BookingController {
    @Autowired
    BookingService service;

    @GetMapping
    public String setId(){
        System.out.println("getWorking"+service.createBookingId());
        return service.createBookingId();
    }
    @PostMapping
    public ResponseEntity addUser(@RequestBody BookingDto dto) {
        service.addBooking(dto);
        StandradResponse response = new StandradResponse(200, "Success", null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping(path="/getall")
    public ResponseEntity getAllRequests() {
        List<BookingDto> allRequests = service.getAllBooking();
        return new ResponseEntity(new StandradResponse (200, "Success", allRequests), HttpStatus.OK);
    }
    @DeleteMapping(params = {"rid"})
    public ResponseEntity deleteUser(@RequestParam String bid) {
        service.deleteBooking(bid);
        return new ResponseEntity(new StandradResponse (200, "Success", null), HttpStatus.CREATED);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity searchBooking(@PathVariable String id) {
        BookingDto requestDTO = service.searchBookingById(id);
        return new ResponseEntity(new StandradResponse (200, "Success", requestDTO), HttpStatus.OK);
    }
}
