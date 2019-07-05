package trainreservationbackend.trainreservationbackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainreservationbackend.trainreservationbackend.model.PaymentInformation;

@Service
public class PaymentInformationCRUDService {

    @Autowired
    private PaymentInformationDao paymentInformationDao;

    public boolean saveToDB(PaymentInformation paymentInformation){
        paymentInformationDao.save(paymentInformation);
        return true;
    }

}
