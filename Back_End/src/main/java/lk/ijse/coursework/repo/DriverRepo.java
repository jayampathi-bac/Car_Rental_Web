package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepo extends JpaRepository<Driver,String> {
//    Driver findDriverById(String id);
//    Driver findDriverByUsername(String username);
//    Driver findDriverByIdAndPassword(String id,String password);
      Driver findDriverById (String id);
      Driver findByName(String name);
      List<Driver> findAllByStatus(int status);

}
