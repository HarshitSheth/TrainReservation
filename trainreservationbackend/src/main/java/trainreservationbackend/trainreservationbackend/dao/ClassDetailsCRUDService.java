package trainreservationbackend.trainreservationbackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainreservationbackend.trainreservationbackend.model.ClassDetails;
import trainreservationbackend.trainreservationbackend.service.ServiceClass;

import java.util.List;

@Service
public class ClassDetailsCRUDService {

    @Autowired
    private ClassDetailsDao classDetailsDao;
    @Autowired
    private ClassInformationCRUDService classInformationCRUDService;
    @Autowired
    private ServiceClass serviceClass;

    public ClassDetails saveToDB(ClassDetails classDetails) {
        ClassDetails classDetails1 = serviceClass.bookReservation(classDetails);
        if(null==classDetails1)
            return null;
        else {
            classDetailsDao.save(classDetails1);
            classDetails1.setClassname(classDetails.getClassname());
            return classDetails1;
        }
    }

    public ClassDetails getFromDBByID(String pnr) {
        return classDetailsDao.findById(pnr).get();
    }

    public List<ClassDetails> getFromDB(){
        return classDetailsDao.findAll();
    }

    public boolean deleteFromDB(String pnr) {
        return serviceClass.cancelReservation(pnr);
    }

}
