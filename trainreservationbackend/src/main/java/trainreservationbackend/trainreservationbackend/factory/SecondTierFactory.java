package trainreservationbackend.trainreservationbackend.factory;

import trainreservationbackend.trainreservationbackend.factoryProduct.SecondTier;
import trainreservationbackend.trainreservationbackend.factoryProduct.TravelClass;

public class SecondTierFactory extends TravelClassFactory {

    @Override
    public TravelClass createTravelClass() {
        return new SecondTier();
    }
}
