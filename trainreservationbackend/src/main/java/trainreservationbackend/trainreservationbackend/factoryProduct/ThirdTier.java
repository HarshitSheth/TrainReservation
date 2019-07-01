package trainreservationbackend.trainreservationbackend.factoryProduct;

import org.springframework.beans.factory.annotation.Autowired;
import trainreservationbackend.trainreservationbackend.dao.ClassInformationCRUDService;

public class ThirdTier implements TravelClass{

    @Autowired
    private ClassInformationCRUDService classInformationCRUDService;

    @Override
    public String getClassNameLowerCase() {
        return "thirdtier";
    }

    @Override
    public String getClassNameUpperCase() {
        return "Third Tier";
    }

    @Override
    public int getClassAvailability() {
        return classInformationCRUDService.getFromDBByID("Third Tier").getAvailability();
    }

    @Override
    public int getTotalClassSeats() {
        return classInformationCRUDService.getFromDBByID("Third Tier").getTotalseats();
    }
}
