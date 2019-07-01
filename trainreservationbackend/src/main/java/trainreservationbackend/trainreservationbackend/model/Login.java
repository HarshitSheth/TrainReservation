package trainreservationbackend.trainreservationbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    private int userid;
    private String username;
    private String email;
    private String contact;
    private String name;
    private String password;
    private String confirmpassword;

    public Login(int userid, String username, String email, String contact, String name, String password, String confirmpassword) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.contact = contact;
        this.name = name;
        this.password = password;
        this.confirmpassword = confirmpassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

    public Login(){}

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

}
