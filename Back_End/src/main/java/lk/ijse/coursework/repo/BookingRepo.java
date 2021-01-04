package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,String> {
    Booking findBookingByBookingid(String id);
}
