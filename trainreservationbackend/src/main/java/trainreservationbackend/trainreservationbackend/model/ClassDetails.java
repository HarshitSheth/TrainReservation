package trainreservationbackend.trainreservationbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "classdetails")
public class ClassDetails {

    private String pnr;
    private String seatnumber;
    private String passengername;
    private String passengerage;
    private String classname;
    private String coach;

    public ClassDetails(){}

    public ClassDetails(String pnr, String seatnumber, String passengername, String passengerage, String classname, String coach) {
        this.pnr = pnr;
        this.seatnumber = seatnumber;
        this.passengername = passengername;
        this.passengerage = passengerage;
        this.classname = classname;
        this.coach = coach;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
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
}
