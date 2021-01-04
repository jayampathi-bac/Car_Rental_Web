package lk.ijse.coursework.dto;

public class UserDto {
    private String userid;
    private String username;
    private String password;
    private int Status;

    public UserDto() {
    }

    public UserDto(String userid, String username, String password, int status) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        Status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
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

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
