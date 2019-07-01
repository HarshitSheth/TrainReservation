package trainreservationbackend.trainreservationbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainreservationbackend.trainreservationbackend.dao.*;
import trainreservationbackend.trainreservationbackend.factory.TravelClassFactory;
import trainreservationbackend.trainreservationbackend.factory.TravelClassObjectFactory;
import trainreservationbackend.trainreservationbackend.factoryProduct.TravelClass;
import trainreservationbackend.trainreservationbackend.model.ClassDetails;
import trainreservationbackend.trainreservationbackend.model.ClassInformation;
import trainreservationbackend.trainreservationbackend.model.Login;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServiceClass {

    @Autowired
    private ClassDetailsCRUDService classDetailsCRUDService;

    @Autowired
    private ClassDetailsDao classDetailsDao;

    @Autowired
    ClassInformationDao classInformationDao;

    @Autowired
    ClassInformationCRUDService classInformationCRUDService;

    @Autowired
    LoginCRUDService loginCRUDService;

    public ServiceClass() {
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
        List<Login> logins = loginCRUDService.getFromDB();
        boolean validateUser = false;
        for(Login login1: logins){
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
            if (null != classDetailsCRUDService.getFromDBByID(pnr)) {
                return null != classDetailsCRUDService.getFromDBByID(pnr).getPassengername();
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

    public ClassDetails getPassengerDetails(String pnr){
        if (validatePnr(pnr)) {
            ClassDetails classdetails = classDetailsCRUDService.getFromDBByID(pnr);
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
            ClassDetails classDetails;
            ClassInformation classInformation;
            classDetails = classDetailsDao.findById(pnr).get();
            classDetails.setPassengername(null);
            classDetails.setPassengerage(null);
            classDetailsDao.save(classDetails);
            TravelClassFactory travelClassFactory = TravelClassObjectFactory.getObjectFactory().getTravelClassObject(classDetails.getClassname());
            TravelClass travelClass = travelClassFactory.getTravelClass();
            classInformation = classInformationCRUDService.getFromDBByID(travelClass.getClassNameLowerCase());
            classInformation.setAvailability(classInformation.getAvailability() + 1);
            classInformationCRUDService.saveToDB(classInformation);
            return true;
        }
        else
            return false;
    }

    public ClassDetails bookReservation(ClassDetails classDetails){
            TravelClassFactory travelClassFactory = TravelClassObjectFactory.getObjectFactory().getTravelClassObject(classDetails.getClassname());
            TravelClass travelClass = travelClassFactory.getTravelClass();
            ClassDetails classDetailsObject = classDetails;
            ClassInformation classInformation;
            classInformation = classInformationDao.findById(travelClass.getClassNameLowerCase()).get();
            if (classInformation.getAvailability() > 0) {
                List<ClassDetails> classDetails1 = classDetailsDao.findAll();
                for (ClassDetails classDetails2 : classDetails1) {
                    if (classDetails2.getClassname().equalsIgnoreCase(travelClass.getClassNameLowerCase())) {
                        if (classDetails2.getPassengername() == null && classDetails2.getPassengerage() == null) {
                            classDetails2.setPassengername(classDetailsObject.getPassengername());
                            classDetails2.setPassengerage(classDetailsObject.getPassengerage());
                            classDetailsObject = classDetails2;
                            ClassInformation classInformation1 = classInformationCRUDService.getFromDBByID(travelClass.getClassNameLowerCase());
                            classInformation1.setAvailability(classInformation1.getAvailability() - 1);
                            classInformationCRUDService.saveToDB(classInformation1);
                            break;
                        }
                    }
                }
            } else
                return null;
            return classDetailsObject;
        }

}
