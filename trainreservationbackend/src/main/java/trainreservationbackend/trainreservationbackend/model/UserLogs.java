package trainreservationbackend.trainreservationbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "userlogs")
public class UserLogs {

    private int logid;
    private String date;
    private String username;
    private String action;
    private String pnr;
    private String classname;
    private String coach;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getLogid() {
        return logid;
    }

    public void setLogid(int logid) {
        this.logid = logid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public UserLogs(int logid, String date, String username, String action, String pnr, String classname, String coach, String seatnumber, String passengername, String passengerage) {
        this.logid = logid;
        this.date = date;
        this.username = username;
        this.action = action;
        this.pnr = pnr;
        this.classname = classname;
        this.coach = coach;
        this.seatnumber = seatnumber;
        this.passengername = passengername;
        this.passengerage = passengerage;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(String seatnumber) {
        this.seatnumber = seatnumber;
    }

    public String getPassengername() {
        return passengername;
    }

    public void setPassengername(String passengername) {
        this.passengername = passengername;
    }

    public String getPassengerage() {
        return passengerage;
    }

    public void setPassengerage(String passengerage) {
        this.passengerage = passengerage;
    }

    private String seatnumber;
    private String passengername;
    private String passengerage;


}
