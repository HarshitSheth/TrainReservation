package trainreservationbackend.trainreservationbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "classinformation")
public class ClassInformation {

    private String classname;
    private int availability;
    private int totalseats;

    public ClassInformation(){}

    public ClassInformation(String classname, int availability, int totalseats) {
        this.classname = classname;
        this.availability = availability;
        this.totalseats = totalseats;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getTotalseats() {
        return totalseats;
    }

    public void setTotalseats(int totalseats) {
        this.totalseats = totalseats;
    }

}
