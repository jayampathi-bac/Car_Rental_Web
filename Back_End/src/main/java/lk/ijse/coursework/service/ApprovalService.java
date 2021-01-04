package lk.ijse.coursework.service;

import lk.ijse.coursework.dto.ApprovalDto;
import lk.ijse.coursework.dto.BookingDto;

import java.util.List;

public interface ApprovalService {
    String createApprovalId();
    void addApproval(ApprovalDto dto);
    void deleteApproval(String id);
    public List<ApprovalDto> getAllBooking();
    ApprovalDto searchApprovalById(String id);
}
