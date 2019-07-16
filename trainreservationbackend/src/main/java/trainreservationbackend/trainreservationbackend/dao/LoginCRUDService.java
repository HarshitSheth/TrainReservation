package trainreservationbackend.trainreservationbackend.dao;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainreservationbackend.trainreservationbackend.model.Login;
//import trainreservationbackend.trainreservationbackend.service.PropertyServiceForJasyptStarter;
import trainreservationbackend.trainreservationbackend.service.ServiceClass;

import java.util.List;

@Service
public class LoginCRUDService {

    @Autowired
    private ServiceClass serviceClass;
    @Autowired
    private LoginDao loginDao;
//    @Autowired
//    private PropertyServiceForJasyptStarter propertyServiceForJasyptStarter;

    public boolean registerUser(Login login) {
        if (serviceClass.validateUser(login)) {
//            BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
//            basicTextEncryptor.setPassword(propertyServiceForJasyptStarter.getProperty());
//            login.setPassword(basicTextEncryptor.encrypt(login.getPassword()));
            loginDao.save(login);
            return true;
        }
        else
            return false;
    }

    public boolean usernameAvailability(String username){
        return serviceClass.validateUser(username);
    }

    public List<Login> getFromDB(){
        return loginDao.findAll();
    }

    public Login loginUser(Login login) {
         return serviceClass.loginUser(login);
    }

}
