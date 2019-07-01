package trainreservationbackend.trainreservationbackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainreservationbackend.trainreservationbackend.model.ClassInformation;

@Service
public class ClassInformationCRUDService {

    @Autowired
    private ClassInformationDao classInformationDao;

    public boolean saveToDB(ClassInformation classInformation){
        classInformationDao.save(classInformation);
        return true;
    }

    public ClassInformation getFromDBByID(String classname){
        return classInformationDao.findById(classname).get();
    }

}
