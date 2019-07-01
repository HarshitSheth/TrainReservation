package trainreservationbackend.trainreservationbackend.factory;

import trainreservationbackend.trainreservationbackend.factoryProduct.General;
import trainreservationbackend.trainreservationbackend.factoryProduct.TravelClass;

public class GeneralFactory extends TravelClassFactory {

@Override
public TravelClass createTravelClass() {
        return new General();
        }

}
