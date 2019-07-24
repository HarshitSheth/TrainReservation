package trainreservationbackend.trainreservationbackend.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import trainreservationbackend.trainreservationbackend.model.UserLogs;

@RestController
@CrossOrigin
public class UserLogsController {

    @PostMapping("/reservationLog")
    public boolean reservationLog(UserLogs userLogs, Model model){
        return true;
    }

}
