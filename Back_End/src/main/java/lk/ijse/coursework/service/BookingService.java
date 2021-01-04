package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.BookingDto;

import java.util.List;

public interface BookingService {

    String createBookingId();
    void addBooking(BookingDto dto);
    void deleteBooking(String id);
    public List<BookingDto> getAllBooking();
    BookingDto searchBookingById(String id);
}
