package lk.ijse.coursework.service.impl;
//
//import lk.ijse.coursework.dto.VehicleDto;
//import lk.ijse.coursework.entity.Vehicle;
//import lk.ijse.coursework.repo.VehicleRepo;
//import lk.ijse.coursework.service.IdGenerateService;
//import lk.ijse.coursework.service.VehicleService;
//import org.apache.commons.io.IOUtils;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.imageio.ImageIO;
//import javax.imageio.stream.ImageOutputStream;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.List;
//@Service
//@Transactional
public class VehiclServiceImpl {
//    @Autowired
//    VehicleRepo repo;
//    @Autowired
//    IdGenerateService generateService;
//    @Autowired
//    ModelMapper mapper;
//    @Override
//    public void saveVehicle(VehicleDto dto) throws IOException {
//        if (!repo.existsById(dto.getId())) {
//           Vehicle u =new Vehicle(dto.getId(),dto.getBrand(),dto.getType(),dto.getPassenger(),null,dto.getTransmission(),dto.getFuel(),dto.getMilage(),dto.getPriceperextrakm(),
//                   dto.getDailyrate(),dto.getFreekmforday(),dto.getMonthlyrate(),dto.getFreekmformonth());
//        //  Vehicle u=mapper.map(dto,Vehicle.class);
//            u.setImage(generateService.getImage(dto.getImage()));
//            repo.save(u);
//        } else {
//            throw new RuntimeException("User already exist..!");
//        }
//    }
//
//    @Override
//    public void updateVehicle(VehicleDto dto) {
//
//    }
//
//    @Override
//    public void deleteVehicle(String id) {
//
//    }
//
//    @Override
//    public List<VehicleDto> getAllVehicles() {
//        return null;
//    }
//
//    @Override
//    public VehicleDto searchVehicle(String id) {
//        return null;
//    }
//

}
