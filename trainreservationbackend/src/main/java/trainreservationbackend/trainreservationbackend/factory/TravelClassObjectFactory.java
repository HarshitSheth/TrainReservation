package trainreservationbackend.trainreservationbackend.factory;


public class TravelClassObjectFactory {
    private static TravelClassObjectFactory travelClassObjectFactory;
    private TravelClassObjectFactory() {
    }

    public static TravelClassObjectFactory getObjectFactory() {
        if (travelClassObjectFactory ==null){
            travelClassObjectFactory = new TravelClassObjectFactory();
        }
        return travelClassObjectFactory;
    }

    public TravelClassFactory getTravelClassObject(String classname){
        if (classname.equalsIgnoreCase("general"))
            return new GeneralFactory();
        else if (classname.equalsIgnoreCase("second tier") || classname.equalsIgnoreCase("secondtier"))
            return new SecondTierFactory();
        else if (classname.equalsIgnoreCase("sleeper"))
            return new SleeperFactory();
        else if (classname.equalsIgnoreCase("third tier") || classname.equalsIgnoreCase("thirdtier"))
            return new ThirdTierFactory();
        else return null;
    }

}
