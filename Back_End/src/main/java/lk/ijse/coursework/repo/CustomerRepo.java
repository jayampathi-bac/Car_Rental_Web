package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer,String> {
//   @Query(value = "SELECT userid FROM Customer ORDER BY userid DESC LIMIT 1 ")
//    String getCustomerid();

}
