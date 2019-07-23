package trainreservationbackend.trainreservationbackend.factoryProduct;

public interface TravelClass {

    String getClassNameLowerCase();
    String getClassNameUpperCase();
    boolean ac();
    String seatsPerCabin();
    String passengerPerSeat();
    String luggageCapacity();

}
