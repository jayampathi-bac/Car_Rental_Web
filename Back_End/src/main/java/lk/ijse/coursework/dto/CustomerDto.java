package lk.ijse.coursework.dto;

public class CustomerDto {

        private String userid;
        private String idnumber;
        private String lisenceno;
        private String name;
        private String contact;
        private String email;
        private String username;
        private String password;
        private int status;
        public CustomerDto() {
        }

        public CustomerDto(String idnumber, String lisenceno, String name, String contact, String email, String username, String password) {
                this.idnumber = idnumber;
                this.lisenceno = lisenceno;
                this.name = name;
                this.contact = contact;
                this.email = email;
                this.username = username;
                this.password = password;
        }

        public CustomerDto(String userid, String idnumber, String lisenceno, String name, String contact, String email, String username, String password, int status) {
                this.userid = userid;
                this.idnumber = idnumber;
                this.lisenceno = lisenceno;
                this.name = name;
                this.contact = contact;
                this.email = email;
                this.username = username;
                this.password = password;
                this.status = status;
        }


        public CustomerDto(String userid, String idnumber, String lisenceno, String name, String contact, String email) {
                this.userid = userid;
                this.idnumber = idnumber;
                this.lisenceno = lisenceno;
                this.name = name;
                this.contact = contact;
                this.email = email;
        }

        public CustomerDto(String userid, String username, String password, int status) {
                this.userid = userid;
                this.username = username;
                this.password = password;
                this.status = status;
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

        public String getContact() {
                return contact;
        }

        public void setContact(String contact) {
                this.contact = contact;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
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

        public int getStatus() {
                return status;
        }

        public void setStatus(int status) {
                this.status = status;
        }
}
