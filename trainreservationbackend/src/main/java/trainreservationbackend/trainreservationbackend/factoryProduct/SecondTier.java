package trainreservationbackend.trainreservationbackend.factoryProduct;

import org.springframework.beans.factory.annotation.Autowired;
import trainreservationbackend.trainreservationbackend.dao.ClassInformationCRUDService;

public class SecondTier implements TravelClass{

    @Autowired
    private ClassInformationCRUDService classInformationCRUDService;

    @Override
    public String getClassNameLowerCase() {
        return "secondtier";
    }

    @Override
    public String getClassNameUpperCase() {
        return "Second Tier";
    }

    @Override
    public int getClassAvailability() {
        return classInformationCRUDService.getFromDBByID("Second Tier").getAvailability();
    }

    @Override
    public int getTotalClassSeats() {
        return classInformationCRUDService.getFromDBByID("Second Tier").getTotalseats();
    }
}
