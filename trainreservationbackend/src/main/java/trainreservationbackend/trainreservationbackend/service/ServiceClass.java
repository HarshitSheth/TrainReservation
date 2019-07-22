package trainreservationbackend.trainreservationbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainreservationbackend.trainreservationbackend.dao.*;
import trainreservationbackend.trainreservationbackend.factory.TravelClassFactory;
import trainreservationbackend.trainreservationbackend.factory.TravelClassObjectFactory;
import trainreservationbackend.trainreservationbackend.factoryProduct.TravelClass;
import trainreservationbackend.trainreservationbackend.model.ReservationDetails;
import trainreservationbackend.trainreservationbackend.model.ClassInformation;
import trainreservationbackend.trainreservationbackend.model.Login;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServiceClass {

    @Autowired
    private ReservationDetailsCRUDService reservationDetailsCRUDService;

    @Autowired
    private ReservationDetailsDao reservationDetailsDao;

    @Autowired
    ClassInformationDao classInformationDao;

    @Autowired
    ClassInformationCRUDService classInformationCRUDService;

    @Autowired
    LoginCRUDService loginCRUDService;

//    @Autowired
//    private PropertyServiceForJasyptStarter propertyServiceForJasyptStarter;

    public ServiceClass() {
    }

//    public boolean usernameAvailability(String username){
//
//    }

    public boolean validateUser(String username){
        List<Login> logins = loginCRUDService.getFromDB();
        boolean available = true;
        for(Login login1: logins){
            if (username.equals(login1.getUsername())){
                available = false;
                break;
            }
        }
        return available;
    }

    public boolean validateUser(Login login){
        List<Login> logins = loginCRUDService.getFromDB();
        boolean available = true;
        for(Login login1: logins){
            if (login.getUsername().equals(login1.getUsername())){
                available = false;
                break;
            }
        }
        return available;
    }

    public Login loginUser(Login login){
//        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
//        basicTextEncryptor.setPassword(propertyServiceForJasyptStarter.getProperty());
        List<Login> logins = loginCRUDService.getFromDB();
        boolean validateUser = false;
        for(Login login1: logins){
//            login1.setPassword(basicTextEncryptor.decrypt(login1.getPassword()));
            if (login.getUsername().equals(login1.getUsername()) && login.getPassword().equalsIgnoreCase(login1.getPassword())){
                login.setName(login1.getName());
                login.setPassword(null);
                login.setUsername(null);
                validateUser = true;
                break;
            }
        }
        if (validateUser) return login;
        else return null;
    }

    private boolean validatePnr(String pnr){
        try {
            if (null != reservationDetailsCRUDService.getFromDBByID(pnr)) {
                return null != reservationDetailsCRUDService.getFromDBByID(pnr).getPassengername();
            }
            else {
                return false;
            }
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public ClassInformation getAvailability(String classname){
        TravelClassFactory travelClassFactory = TravelClassObjectFactory.getObjectFactory().getTravelClassObject(classname);
        TravelClass travelClass = travelClassFactory.getTravelClass();
        ClassInformation classinformation = classInformationCRUDService.getFromDBByID(travelClass.getClassNameLowerCase());
        classinformation.setClassname(travelClass.getClassNameUpperCase());
        return classinformation;
    }

    public String seatsPerCabin(String className){
        TravelClassFactory travelClassFactory = TravelClassObjectFactory.getObjectFactory().getTravelClassObject(className);
        TravelClass travelClass = travelClassFactory.getTravelClass();
        return travelClass.seatsPerCabin();
    }

    public String passengerPerSeat(String className){
        TravelClassFactory travelClassFactory = TravelClassObjectFactory.getObjectFactory().getTravelClassObject(className);
        TravelClass travelClass = travelClassFactory.getTravelClass();
        return travelClass.passengerPerSeat();
    }

    public boolean classAc(String className){
        TravelClassFactory travelClassFactory = TravelClassObjectFactory.getObjectFactory().getTravelClassObject(className);
        TravelClass travelClass = travelClassFactory.getTravelClass();
        return travelClass.ac();
    }

    public ReservationDetails getPassengerDetails(String pnr){
        if (validatePnr(pnr)) {
            ReservationDetails classdetails = reservationDetailsCRUDService.getFromDBByID(pnr);
            TravelClassFactory travelClassFactory = TravelClassObjectFactory.getObjectFactory().getTravelClassObject(classdetails.getClassname());
            TravelClass travelClass = travelClassFactory.getTravelClass();
            classdetails.setClassname(travelClass.getClassNameUpperCase());
            return classdetails;
        }
        else
            return null;
    }

    public boolean cancelReservation(String pnr){
        if (validatePnr(pnr)) {
            ReservationDetails reservationDetails;
            ClassInformation classInformation;
            reservationDetails = reservationDetailsDao.findById(pnr).get();
            reservationDetails.setPassengername(null);
            reservationDetails.setPassengerage(null);
            reservationDetailsDao.save(reservationDetails);
            TravelClassFactory travelClassFactory = TravelClassObjectFactory.getObjectFactory().getTravelClassObject(reservationDetails.getClassname());
            TravelClass travelClass = travelClassFactory.getTravelClass();
            classInformation = classInformationCRUDService.getFromDBByID(travelClass.getClassNameLowerCase());
            classInformation.setAvailability(classInformation.getAvailability() + 1);
            classInformationCRUDService.saveToDB(classInformation);
            return true;
        }
        else
            return false;
    }

    public boolean verifyClassAvailability(ClassInformation classInformation){
        return classInformation.getAvailability() > 0;
    }

    public boolean verifyClassAvailability(String classname){
        TravelClassFactory travelClassFactory = TravelClassObjectFactory.getObjectFactory().getTravelClassObject(classname);
        TravelClass travelClass = travelClassFactory.getTravelClass();
        return  classInformationCRUDService.getFromDBByID(travelClass.getClassNameLowerCase()).getAvailability() > 0;
    }

    public ReservationDetails bookReservation(ReservationDetails reservationDetails){
            TravelClassFactory travelClassFactory = TravelClassObjectFactory.getObjectFactory().getTravelClassObject(reservationDetails.getClassname());
            TravelClass travelClass = travelClassFactory.getTravelClass();
            ReservationDetails reservationDetailsObject = reservationDetails;
            ClassInformation classInformation;
            classInformation = classInformationDao.findById(travelClass.getClassNameLowerCase()).get();
            if (verifyClassAvailability(classInformation)) {
                List<ReservationDetails> reservationDetails1 = reservationDetailsDao.findAll();
                for (ReservationDetails reservationDetails2 : reservationDetails1) {
                    if (reservationDetails2.getClassname().equalsIgnoreCase(travelClass.getClassNameLowerCase())) {
                        if (reservationDetails2.getPassengername() == null && reservationDetails2.getPassengerage() == null) {
                            reservationDetails2.setPassengername(reservationDetailsObject.getPassengername());
                            reservationDetails2.setPassengerage(reservationDetailsObject.getPassengerage());
                            reservationDetailsObject = reservationDetails2;
                            ClassInformation classInformation1 = classInformationCRUDService.getFromDBByID(travelClass.getClassNameLowerCase());
                            classInformation1.setAvailability(classInformation1.getAvailability() - 1);
                            classInformationCRUDService.saveToDB(classInformation1);
                            break;
                        }
                    }
                }
            } else
                return null;
            return reservationDetailsObject;
        }

}
