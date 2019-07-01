package trainreservationbackend.trainreservationbackend.factoryProduct;

import org.springframework.beans.factory.annotation.Autowired;
import trainreservationbackend.trainreservationbackend.dao.ClassInformationCRUDService;

public class General implements TravelClass {

    @Autowired
    private ClassInformationCRUDService classInformationCRUDService;

    @Override
    public String getClassNameLowerCase() {
        return "general";
    }

    @Override
    public String getClassNameUpperCase() {
        return "General";
    }

    @Override
    public int getClassAvailability() {
        return classInformationCRUDService.getFromDBByID("general").getAvailability();
    }

    @Override
    public int getTotalClassSeats() {
        return classInformationCRUDService.getFromDBByID("general").getTotalseats();
    }
}
