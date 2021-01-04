package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.Vehicle01Dto;
import lk.ijse.coursework.dto.VehicleDto;

import java.io.IOException;
import java.util.List;

public interface VehicleService {
    void saveVehicle(Vehicle01Dto dto);
    void updateVehicle(Vehicle01Dto dto);
    void deleteVehicle(String id);
    public List<Vehicle01Dto> getAllVehicles();
    Vehicle01Dto searchVehicle(String id);

}
