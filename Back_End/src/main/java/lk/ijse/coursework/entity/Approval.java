package lk.ijse.coursework.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Approval {
    @Id
    private String approvalid;
    private String bookingid;
    private String driverid;
    private String vehicleid;

    public Approval() {
    }

    public Approval(String approvalid, String bookingid, String driverid, String vehicleid) {
        this.approvalid = approvalid;
        this.bookingid = bookingid;
        this.driverid = driverid;
        this.vehicleid = vehicleid;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public String getApprovalid() {
        return approvalid;
    }

    public void setApprovalid(String approvalid) {
        this.approvalid = approvalid;
    }

    public String getDriverid() {
        return driverid;
    }

    public void setDriverid(String driverid) {
        this.driverid = driverid;
    }

    public String getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(String vehicleid) {
        this.vehicleid = vehicleid;
    }
}
