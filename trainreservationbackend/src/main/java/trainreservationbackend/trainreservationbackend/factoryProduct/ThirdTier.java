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
    public boolean ac(){
        return true;
    }

    @Override
    public String seatsPerCabin() {
        return "2";
    }

    @Override
    public String passengerPerSeat() {
        return "1";
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
