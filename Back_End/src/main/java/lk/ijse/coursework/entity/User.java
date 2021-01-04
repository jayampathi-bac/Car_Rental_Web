package lk.ijse.coursework.entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    private  String userid;
    private String username;
    private String password;
    private int status;

    public User() {
    }

    public User(String userid, String username, String password, int status) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public String getUserid() {
        return userid;
    }

    public int getStatus() {
        return status;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int gettatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
