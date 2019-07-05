package trainreservationbackend.trainreservationbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trainreservationbackend.trainreservationbackend.dao.ReservationDetailsCRUDService;
import trainreservationbackend.trainreservationbackend.model.ReservationDetails;
import trainreservationbackend.trainreservationbackend.model.ClassInformation;
import trainreservationbackend.trainreservationbackend.service.ServiceClass;

@RestController
@CrossOrigin
public class ReservationDetailsController {

    @Autowired
    ReservationDetailsCRUDService reservationDetailsCRUDService;
    @Autowired
    ServiceClass serviceClass;

    @PostMapping("/reservation")
    public ReservationDetails write(@RequestBody ReservationDetails reservationDetails, Model model){
        return reservationDetailsCRUDService.saveToDB(reservationDetails);
    }

    @RequestMapping("/reservation")
    public String reserve(){
        return "Get working";
    }

    @RequestMapping("/passengerDetails")
    public ReservationDetails read(@RequestBody String pnr, Model model){
        return serviceClass.getPassengerDetails(pnr);
    }

    @PostMapping(value = "/cancelReservation")
    public boolean cancel(@RequestBody String pnr, Model model){
        return reservationDetailsCRUDService.deleteFromDB(pnr);
    }

    @RequestMapping(value = "/getAvailability")
    public ClassInformation get(@RequestBody String classname, Model model){
        return serviceClass.getAvailability(classname);
    }
}
