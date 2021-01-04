package lk.ijse.coursework.repo;

import lk.ijse.coursework.entity.Approval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApprovalRepo extends JpaRepository<Approval,String> {
    Approval findApprovalByApprovalid(String id);
}
