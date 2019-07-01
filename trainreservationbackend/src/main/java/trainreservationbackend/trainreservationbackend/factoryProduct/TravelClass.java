package trainreservationbackend.trainreservationbackend.factoryProduct;

public interface TravelClass {

    String getClassNameLowerCase();
    String getClassNameUpperCase();
    int getClassAvailability();
    int getTotalClassSeats();

}
