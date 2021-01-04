package lk.ijse.coursework.service.impl;

import lk.ijse.coursework.dto.ApprovalDto;
import lk.ijse.coursework.dto.BookingDto;
import lk.ijse.coursework.entity.Approval;
import lk.ijse.coursework.entity.Booking;
import lk.ijse.coursework.repo.ApprovalRepo;
import lk.ijse.coursework.repo.BookingRepo;
import lk.ijse.coursework.service.ApprovalService;
import lk.ijse.coursework.service.IdGenerateService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ApprovalServiceimpl implements ApprovalService {

    @Autowired
    IdGenerateService idGenerateService;
    @Autowired
    ApprovalRepo repo;
    @Autowired
    ModelMapper mapper;
    @Override
    public String createApprovalId() {
        return idGenerateService.genarateId("AP");
    }

    @Override
    public void addApproval(ApprovalDto dto) {
        if (!repo.existsById(dto.getApprovalid())) {
            Approval u = mapper.map(dto, Approval.class);
            repo.save(u);
        } else {
            throw new RuntimeException("User already exist..!");
        }
    }

    @Override
    public void deleteApproval(String id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("No driver for delete ID: " + id);
        }
    }

    @Override
    public List<ApprovalDto> getAllBooking() {
        List<Approval> all = repo.findAll();
        return mapper.map(all, new TypeToken<List<ApprovalDto>>() {
        }.getType());
    }

    @Override
    public ApprovalDto searchApprovalById(String id) {
        return null;
    }
}
