package trainreservationbackend.trainreservationbackend.factoryProduct;

import org.springframework.beans.factory.annotation.Autowired;
import trainreservationbackend.trainreservationbackend.dao.ClassInformationCRUDService;

public class Sleeper implements TravelClass{

    @Autowired
    private ClassInformationCRUDService classInformationCRUDService;

    @Override
    public String getClassNameLowerCase() {
        return "sleeper";
    }

    @Override
    public String getClassNameUpperCase() {
        return "Sleeper";
    }

    @Override
    public int getClassAvailability() {
        return classInformationCRUDService.getFromDBByID("sleeper").getAvailability();
    }

    @Override
    public int getTotalClassSeats() {
        return classInformationCRUDService.getFromDBByID("sleeper").getTotalseats();
    }
}
