package trainreservationbackend.trainreservationbackend.factory;

import trainreservationbackend.trainreservationbackend.factoryProduct.Sleeper;
import trainreservationbackend.trainreservationbackend.factoryProduct.TravelClass;

public class SleeperFactory extends TravelClassFactory {

    @Override
    public TravelClass createTravelClass() {
        return new Sleeper();
    }
}
