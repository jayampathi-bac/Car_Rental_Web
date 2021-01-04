package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.Vehicle01Dto;
import lk.ijse.coursework.entity.Vehicle;
import lk.ijse.coursework.entity.Vehicle01;
import lk.ijse.coursework.repo.VehicleRepo;
import lk.ijse.coursework.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class VehicleServic01Impl implements VehicleService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    VehicleRepo repo;
    @Override
    public void saveVehicle(Vehicle01Dto dto) {
        if (!repo.existsById(dto.getId())) {
            Vehicle01 u = modelMapper.map(dto, Vehicle01.class);
            repo.save(u);
        } else {
            throw new RuntimeException("User already exist..!");
        }
    }

    @Override
    public void updateVehicle(Vehicle01Dto dto) {
        if (repo.existsById(dto.getId())) {
            Vehicle01 u = modelMapper.map(dto, Vehicle01.class);
            repo.save(u);
        } else {
            throw new RuntimeException("No such Vehicle for update..!");
        }
    }

    @Override
    public void deleteVehicle(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No vehicle for delete ID: " + id);
        }
    }

    @Override
    public List<Vehicle01Dto> getAllVehicles() {
        List<Vehicle01> all = repo.findAll();
        return modelMapper.map(all, new TypeToken<List<Vehicle01Dto>>() {
        }.getType());
    }

    @Override
    public Vehicle01Dto searchVehicle(String id) {
        Optional<Vehicle01> vehicle01 = repo.findById(id);
        if (vehicle01.isPresent()) {
            return modelMapper.map(vehicle01.get(), Vehicle01Dto.class);
        } else {
            throw new RuntimeException("No Vehicle for id: " + id);
        }
    }

}
