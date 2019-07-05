package trainreservationbackend.trainreservationbackend.dao;

import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trainreservationbackend.trainreservationbackend.model.ReservationDetails;
import trainreservationbackend.trainreservationbackend.service.ServiceClass;

import java.util.List;

@Service
public class ReservationDetailsCRUDService {

    @Autowired
    private ReservationDetailsDao reservationDetailsDao;
    @Autowired
    private ClassInformationCRUDService classInformationCRUDService;
    @Autowired
    private ServiceClass serviceClass;

    public ReservationDetails saveToDB(ReservationDetails reservationDetails) {
        ReservationDetails reservationDetails1 = serviceClass.bookReservation(reservationDetails);
        if(null== reservationDetails1)
            return null;
        else {
            reservationDetailsDao.save(reservationDetails1);
            reservationDetails1.setClassname(reservationDetails.getClassname());
            return reservationDetails1;
        }
    }

    public ReservationDetails getFromDBByID(String pnr) {
        return reservationDetailsDao.findById(pnr).get();
    }

    public List<ReservationDetails> getFromDB(){
        return reservationDetailsDao.findAll();
    }

    public boolean deleteFromDB(String pnr) {
        return serviceClass.cancelReservation(pnr);
    }

}
