package trainreservationbackend.trainreservationbackend.factory;

import trainreservationbackend.trainreservationbackend.factoryProduct.ThirdTier;
import trainreservationbackend.trainreservationbackend.factoryProduct.TravelClass;

public class ThirdTierFactory extends TravelClassFactory {

    @Override
    public TravelClass createTravelClass() {
        return new ThirdTier();
    }
}
