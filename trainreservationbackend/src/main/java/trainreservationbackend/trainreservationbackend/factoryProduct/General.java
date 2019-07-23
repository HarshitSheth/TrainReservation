package trainreservationbackend.trainreservationbackend.factoryProduct;

import org.springframework.beans.factory.annotation.Autowired;
import trainreservationbackend.trainreservationbackend.dao.ClassInformationCRUDService;
import trainreservationbackend.trainreservationbackend.factory.TravelClassFactory;
import trainreservationbackend.trainreservationbackend.factory.TravelClassObjectFactory;
import trainreservationbackend.trainreservationbackend.model.ClassInformation;

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
    public boolean ac(){
        return false;
    }

    @Override
    public String seatsPerCabin() {
        return "2";
    }

    @Override
    public String passengerPerSeat() {
        return "3";
    }

    @Override
    public String luggageCapacity() {
        return "15";
    }

}
