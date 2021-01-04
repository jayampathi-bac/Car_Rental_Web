package lk.ijse.coursework.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer{
    @Id
    private String userid;
    private String idnumber;
    private String lisenceno;
    private String name;
    private int contact;
    private String email;
//    private String username;
//    private String password;


    public Customer() {
    }

    public Customer(String userid, String idnumber, String lisenceno, String name, int contact, String email) {
        this.userid = userid;
        this.idnumber = idnumber;
        this.lisenceno = lisenceno;
        this.name = name;
        this.contact = contact;
        this.email = email;
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

    public String getLisenceno() {
        return lisenceno;
    }

    public void setLisenceno(String lisenceno) {
        this.lisenceno = lisenceno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
