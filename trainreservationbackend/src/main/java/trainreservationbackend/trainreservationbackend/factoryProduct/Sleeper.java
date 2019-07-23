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
    public boolean ac(){
        return false;
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
    public String luggageCapacity() {
        return "30";
    }

}
