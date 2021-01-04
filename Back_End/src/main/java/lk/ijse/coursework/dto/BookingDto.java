package lk.ijse.coursework.dto;

public class BookingDto {
    private String bookingid;
    private String userid;
    private String vehicleid;
    private String bookingdate;
    private String pickupdate;
    private String returndate;
    private String waiver;
    private String reqdriver;
    private int status;
    public BookingDto() {
    }

    public BookingDto(String bookingid, String userid, String vehicleid, String bookingdate, String pickupdate, String returndate, String waiver, String reqdriver, int status) {
        this.bookingid = bookingid;
        this.userid = userid;
        this.vehicleid = vehicleid;
        this.bookingdate = bookingdate;
        this.pickupdate = pickupdate;
        this.returndate = returndate;
        this.waiver = waiver;
        this.reqdriver = reqdriver;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(String vehicleid) {
        this.vehicleid = vehicleid;
    }

    public String getReqdriver() {
        return reqdriver;
    }

    public void setReqdriver(String reqdriver) {
        this.reqdriver = reqdriver;
    }

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

    public String getPickupdate() {
        return pickupdate;
    }

    public void setPickupdate(String pickupdate) {
        this.pickupdate = pickupdate;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public String getWaiver() {
        return waiver;
    }

    public void setWaiver(String waiver) {
        this.waiver = waiver;
    }
}
