package lk.ijse.coursework.dto;

public class AdminDto {
    private String userid;
    private String idnumber;
    private String name;
    private String address;
    private int contact;

    public AdminDto(String userid, String idnumber, String name, String address, int contact) {
        this.userid = userid;
        this.idnumber = idnumber;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public AdminDto() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }
}
