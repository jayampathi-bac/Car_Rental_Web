package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepo extends JpaRepository<User,String> {
    User getByUsername(String username);
    User findUserByUsername(String username);
    List<User> findAllByUseridStartsWith(String letter);
    User findUserByUserid(String id);

}
