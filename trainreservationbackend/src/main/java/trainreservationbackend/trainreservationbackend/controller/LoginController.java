package trainreservationbackend.trainreservationbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trainreservationbackend.trainreservationbackend.dao.LoginCRUDService;
import trainreservationbackend.trainreservationbackend.model.Login;

@RestController
@CrossOrigin
public class LoginController {

    @Autowired
    LoginCRUDService loginCRUDService;

    @RequestMapping("/usernameAvailability/{username}")
    public boolean usernameAvailability(@PathVariable String username){
        return loginCRUDService.usernameAvailability(username);
    }

    @PostMapping("/register")
    public boolean register(@RequestBody Login login, Model model){
        return loginCRUDService.registerUser(login);
    }

    @PostMapping("/login")
    public Login login(@RequestBody Login login, Model model){
        return loginCRUDService.loginUser(login);
    }

}
