package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.DriverDto;
import lk.ijse.coursework.entity.Driver;
import lk.ijse.coursework.repo.DriverRepo;
import lk.ijse.coursework.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    DriverRepo repo;

    @Override
    public void saveDriver(DriverDto dto) {
        if (!repo.existsById(dto.getId())) {
            Driver u = modelMapper.map(dto, Driver.class);
            repo.save(u);
        } else {
            throw new RuntimeException("User already exist..!");
        }
    }

    @Override
    public void updateDriver(DriverDto dto) {
        if (repo.existsById(dto.getId())) {
            Driver u = modelMapper.map(dto, Driver.class);
            repo.save(u);
        } else {
            throw new RuntimeException("No such Driver for update..!");
        }
    }

    @Override
    public void deleteDriver(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No driver for delete ID: " + id);
        }
    }

    @Override
    public List<DriverDto> getAllDrivers() {
        List<Driver> all = repo.findAll();
        return modelMapper.map(all, new TypeToken<List<DriverDto>>() {
        }.getType());

    }

    @Override
    public DriverDto searchDriverById(String id) {
        Optional<Driver> driver = ofNullable(repo.findDriverById(id));
        if (driver.isPresent()) {
            return modelMapper.map(driver.get(), DriverDto.class);
        } else {
            throw new RuntimeException("No driver for id: " + id);
        }
    }

    @Override
    public DriverDto searchDriverByUsername(String username) {
//        Optional<Driver> driver = Optional.ofNullable(repo.findDriverByUsername(username));
//        if (driver.isPresent()) {
//            return modelMapper.map(driver.get(), DriverDto.class);
//        } else {
//            throw new RuntimeException("No Driver for username: " + username);
//        }
        return null;
    }

    @Override
    public DriverDto searchDriverByIdAndPass(String id, String password) {
//        Optional<Driver> driver = Optional.ofNullable(repo.findDriverByIdAndPassword(id,password));
//        if (driver.isPresent()) {
//            return modelMapper.map(driver.get(), DriverDto.class);
//        } else {
//            throw new RuntimeException("No Driver for password given ");
//        }
        return null;
    }

    @Override
    public List<DriverDto> getAllfreeDrivers() {
        List<Driver> allByStatus = repo.findAllByStatus(0);
        return modelMapper.map(allByStatus, new TypeToken<List<DriverDto>>() {
        }.getType());
    }

}
