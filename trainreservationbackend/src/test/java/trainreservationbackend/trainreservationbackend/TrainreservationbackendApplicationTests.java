package trainreservationbackend.trainreservationbackend;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import trainreservationbackend.trainreservationbackend.dao.PaymentInformationCRUDService;
import trainreservationbackend.trainreservationbackend.model.PaymentInformation;
import trainreservationbackend.trainreservationbackend.model.ReservationDetails;
import trainreservationbackend.trainreservationbackend.model.Login;
import trainreservationbackend.trainreservationbackend.service.ServiceClass;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainreservationbackendApplicationTests {

    @Autowired
    ServiceClass serviceClass;

    @Autowired
    PaymentInformationCRUDService paymentInformationCRUDService;

    @Test
    public void checkTrueUserValidation(){
        Login login = new Login();
        login.setUsername("hasheth");
        login.setPassword("Abcd@1234");
        Login loginName = serviceClass.loginUser(login);
        Assert.assertEquals("harshit", loginName.getName());
    }

    @Test
    public void checkFalseUserValidation(){
        Login login = new Login();
        login.setUsername("hjsdh");
        login.setPassword("Gkjcd@1234");
        Login loginName = serviceClass.loginUser(login);
        Assert.assertNotNull("harshit", loginName.getName());
    }

    @Test
    public void checkTrueUserRegistration(){
        Login login = new Login();
        login.setUsername("username");
        login.setName("name");
        login.setPassword("abcd");
        login.setEmail("email@email.com");
        Assert.assertTrue(serviceClass.validateUser(login));
    }

    @Test
    public void checkFalseUserRegistration(){
        Login login = new Login();
        login.setUsername("hsheth");
        login.setName("name");
        login.setPassword("abcd");
        login.setEmail("email@email.com");
        Assert.assertTrue(serviceClass.validateUser(login));
    }

    @Test
    public void validatePassengerDetails(){
        ReservationDetails reservationDetails = serviceClass.getPassengerDetails("10");
        Assert.assertNotNull(reservationDetails);
    }

    @Test
    public void validateCancelReservation(){
        Assert.assertTrue(serviceClass.cancelReservation("10"));

    }

    @Test
    public void validateBookReservation(){
        ReservationDetails classdetails = new ReservationDetails();
        classdetails.setPassengername("harshit");
        classdetails.setPassengerage("20");
        classdetails.setClassname("general");
        Assert.assertNotNull(serviceClass.bookReservation(classdetails));
    }

    @Test
    public void validatePayment(){
        PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setCardholdername("jsdjh");
        paymentInformation.setPaymentamount(1000);
        Assert.assertTrue(paymentInformationCRUDService.saveToDB(paymentInformation));
    }

}
