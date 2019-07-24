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

    @RequestMapping("/passengerDetails/{pnr}")
    public ReservationDetails read(@PathVariable String pnr){
        return serviceClass.getPassengerDetails(pnr);
    }

    @RequestMapping("/seatsPerCabin/{className}")
    public String className(@PathVariable String className){
        return serviceClass.seatsPerCabin(className);
    }

    @RequestMapping("/passengerPerSeat/{className}")
    public String passengerPerSeat(@PathVariable String className){
        return serviceClass.passengerPerSeat(className);
    }

    @RequestMapping("/classAc/{className}")
    public boolean classAc(@PathVariable String className){
        return serviceClass.classAc(className);
    }

    @RequestMapping("/luggageCapacity/{className}")
    public String luggageCapacity(@PathVariable String className) {
        return  serviceClass.luggageCapacity(className);
    }

    @PostMapping(value = "/cancelReservation")
    public boolean cancel(@RequestBody String pnr, Model model){
        return reservationDetailsCRUDService.deleteFromDB(pnr);
    }

    @RequestMapping(value = "/getAvailability/{classname}")
    public ClassInformation get(@PathVariable String classname){
        return serviceClass.getAvailability(classname);
    }
}
