package trainreservationbackend.trainreservationbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trainreservationbackend.trainreservationbackend.dao.ClassDetailsCRUDService;
import trainreservationbackend.trainreservationbackend.model.ClassDetails;
import trainreservationbackend.trainreservationbackend.model.ClassInformation;
import trainreservationbackend.trainreservationbackend.service.ServiceClass;

@RestController
@CrossOrigin
public class ClassDetailsController {

    @Autowired
    ClassDetailsCRUDService classDetailsCRUDService;
    @Autowired
    ServiceClass serviceClass;

    @PostMapping("/reservation")
    public ClassDetails write(@RequestBody ClassDetails classDetails, Model model){
        return classDetailsCRUDService.saveToDB(classDetails);
    }

    @RequestMapping("/reservation")
    public String reserve(){
        return "Get working";
    }

    @RequestMapping("/passengerDetails")
    public ClassDetails read(@RequestBody String pnr, Model model){
        return serviceClass.getPassengerDetails(pnr);
    }

    @PostMapping(value = "/cancelReservation")
    public boolean cancel(@RequestBody String pnr, Model model){
        return classDetailsCRUDService.deleteFromDB(pnr);
    }

    @RequestMapping(value = "/getAvailability")
    public ClassInformation get(@RequestBody String classname, Model model){
        return serviceClass.getAvailability(classname);
    }
}
