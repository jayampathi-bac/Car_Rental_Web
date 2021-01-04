package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.DriverDto;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDto dto);
    void updateDriver(DriverDto dto);
    void deleteDriver(String id);
    List<DriverDto> getAllDrivers();
    DriverDto searchDriverById(String id);
    DriverDto searchDriverByUsername(String username);
    DriverDto searchDriverByIdAndPass(String id,String password);
    List<DriverDto> getAllfreeDrivers();

}
