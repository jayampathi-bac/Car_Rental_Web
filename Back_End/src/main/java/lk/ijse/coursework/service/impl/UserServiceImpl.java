package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.UserDto;
import lk.ijse.coursework.entity.User;
import lk.ijse.coursework.repo.UserRepo;
import lk.ijse.coursework.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public UserDto searchUserbyUserName(String name) {
        Optional<User> user = Optional.ofNullable(repo.findUserByUsername(name));
        System.out.println(name);
        //User user = repo.findUserByUsername(name);
        System.out.println(user);
//        Optional<User> byId = repo.findById(user.getId());
        if (user.isPresent()) {
            return mapper.map(user.get(),UserDto.class);
        } else {
            throw new RuntimeException("No user for User Name: " + name);
        }

    }

    @Override
    public void saveUser(UserDto dto) {
        if (!repo.existsById(dto.getUserid())) {
            User u = mapper.map(dto, User.class);
            repo.save(u);
        } else {
            throw new RuntimeException("User already exist..!");
        }
    }

    @Override
    public void updateUser(UserDto dto) {

    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public String getUsernamebyId(String id) {
        Optional<User> byId = repo.findById(id);
        return byId.get().getUsername();
        //    repo.findUserByUserid(id);
    }
}
