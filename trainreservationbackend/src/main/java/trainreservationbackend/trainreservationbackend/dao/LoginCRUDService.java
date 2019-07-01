package trainreservationbackend.trainreservationbackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainreservationbackend.trainreservationbackend.model.Login;
import trainreservationbackend.trainreservationbackend.service.ServiceClass;

import java.util.List;

@Service
public class LoginCRUDService {

    @Autowired
    private ServiceClass serviceClass;

    @Autowired
    private LoginDao loginDao;

    public boolean registerUser(Login login) {
        if (serviceClass.validateUser(login)) {
            loginDao.save(login);
            return true;
        }
        else
            return false;
    }

    public List<Login> getFromDB(){
        return loginDao.findAll();
    }

    public Login loginUser(Login login) {
         return serviceClass.loginUser(login);
    }

}
