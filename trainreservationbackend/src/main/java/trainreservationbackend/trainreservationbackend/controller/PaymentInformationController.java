package trainreservationbackend.trainreservationbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import trainreservationbackend.trainreservationbackend.dao.PaymentInformationCRUDService;
import trainreservationbackend.trainreservationbackend.model.PaymentInformation;

@RestController
@CrossOrigin
public class PaymentInformationController {

    @Autowired
    private PaymentInformationCRUDService paymentInformationCRUDService;

    @PostMapping("/payment")
    public boolean paymentDetails(@RequestBody PaymentInformation paymentInformation, Model model) {
        return paymentInformationCRUDService.saveToDB(paymentInformation);
    }
}

