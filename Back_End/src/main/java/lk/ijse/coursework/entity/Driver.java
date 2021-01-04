package lk.ijse.coursework.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Driver {
    @Id
    private String id;
    private String name;
    private int contact;
    private int status;

    public Driver() {
    }

    public Driver(String id, String name, int contact, int status) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
