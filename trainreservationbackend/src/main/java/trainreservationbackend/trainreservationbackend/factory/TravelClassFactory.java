package trainreservationbackend.trainreservationbackend.factory;

import trainreservationbackend.trainreservationbackend.factoryProduct.TravelClass;

public abstract class TravelClassFactory {

    public TravelClass getTravelClass(){
        return this.createTravelClass();
    }

    public abstract TravelClass createTravelClass();

}
