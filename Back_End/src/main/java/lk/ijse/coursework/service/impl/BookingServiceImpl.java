package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.BookingDto;
import lk.ijse.coursework.dto.DriverDto;
import lk.ijse.coursework.entity.Booking;
import lk.ijse.coursework.entity.Driver;
import lk.ijse.coursework.repo.BookingRepo;
import lk.ijse.coursework.service.BookingService;
import lk.ijse.coursework.service.IdGenerateService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
  @Autowired
    IdGenerateService idGenerateService;

  @Autowired
  BookingRepo repo;
  @Autowired
  ModelMapper mapper;
  @Override
    public String createBookingId() {
        return idGenerateService.genarateId("B");
    }

    @Override
    public void addBooking(BookingDto dto) {
    if (!repo.existsById(dto.getBookingid())) {
      Booking u = mapper.map(dto, Booking.class);
      repo.save(u);
    } else {
      throw new RuntimeException("User already exist..!");
    }
  }

  @Override
  public void deleteBooking(String id) {
    if (repo.existsById(id)) {
      repo.deleteById(id);
    } else {
      throw new RuntimeException("No driver for delete ID: " + id);
    }
  }

  @Override
  public List<BookingDto> getAllBooking() {
    List<Booking> all = repo.findAll();
    return mapper.map(all, new TypeToken<List<BookingDto>>() {
    }.getType());
  }

  @Override
  public BookingDto searchBookingById(String id) {
    Booking b = repo.findBookingByBookingid(id);
    return mapper.map(b,BookingDto.class);
  }
}
