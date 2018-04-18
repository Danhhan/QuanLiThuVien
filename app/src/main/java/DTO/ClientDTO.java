package DTO;

/**
 * Created by Develop on 3/24/2018.
 */

public class ClientDTO {
    String id_user,pwd_user,name_user,email_user,phone_user;


    public ClientDTO() {
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getPwd_user() {
        return pwd_user;
    }

    public void setPwd_user(String pwd_user) {
        this.pwd_user = pwd_user;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getPhone_user() {
        return phone_user;
    }

    public void setPhone_user(String phone_user) {
        this.phone_user = phone_user;
    }
}
