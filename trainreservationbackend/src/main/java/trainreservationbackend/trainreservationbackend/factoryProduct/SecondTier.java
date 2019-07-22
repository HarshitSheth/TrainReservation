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
    public boolean ac(){
        return true;
    }

    @Override
    public String seatsPerCabin() {
        return "1";
    }

    @Override
    public String passengerPerSeat() {
        return "1";
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
