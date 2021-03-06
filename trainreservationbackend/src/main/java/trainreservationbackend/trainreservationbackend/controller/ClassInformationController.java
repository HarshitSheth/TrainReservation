package trainreservationbackend.trainreservationbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trainreservationbackend.trainreservationbackend.dao.ClassInformationCRUDService;
import trainreservationbackend.trainreservationbackend.dao.ClassInformationDao;
import trainreservationbackend.trainreservationbackend.model.ClassInformation;
import trainreservationbackend.trainreservationbackend.service.ServiceClass;

@RestController
@CrossOrigin
public class ClassInformationController {

    @Autowired
    ClassInformationCRUDService classInformationCRUDService;
    @Autowired
    ClassInformationDao classInformationDao;
    @Autowired
    ServiceClass serviceClass;

    @PostMapping("/cipost")
    public boolean write(@RequestBody ClassInformation classInformation, Model model){
        return classInformationCRUDService.saveToDB(classInformation);
    }

    @RequestMapping("/cipost")
    public String get(){
        return "Get ci working";
    }

    @RequestMapping("/test")
    public ClassInformation getClassDetails(){
        return classInformationDao.findById("secondtier").get();
    }

    @RequestMapping("/verifyClassAvailability/{classname}")
    public boolean verifyAvailability(@PathVariable String classname, Model model){
        return serviceClass.verifyClassAvailability(classname);
    }
}
