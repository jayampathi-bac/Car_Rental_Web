package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.Vehicle;
import lk.ijse.coursework.entity.Vehicle01;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle01,String> {

}
