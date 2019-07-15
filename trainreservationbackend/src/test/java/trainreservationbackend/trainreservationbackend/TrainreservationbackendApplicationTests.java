package trainreservationbackend.trainreservationbackend;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import trainreservationbackend.trainreservationbackend.dao.PaymentInformationCRUDService;
import trainreservationbackend.trainreservationbackend.model.PaymentInformation;
import trainreservationbackend.trainreservationbackend.model.ReservationDetails;
import trainreservationbackend.trainreservationbackend.model.Login;
import trainreservationbackend.trainreservationbackend.service.ServiceClass;

@EnableEncryptableProperties
@PropertySource(name="EncryptedProperties", value = "classpath:encrypted.properties")
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
        Assert.assertNull(loginName);
    }

    @Test
    public void checkUserRegistration(){
        Login login = new Login();
        login.setUsername("username");
        login.setName("name");
        login.setPassword("abcd");
        login.setEmail("email@email.com");
        Assert.assertTrue(serviceClass.validateUser(login));
    }

    @Test
    public void validatePassengerDetails(){
        ReservationDetails reservationDetails = serviceClass.getPassengerDetails("10");
        Assert.assertNull(reservationDetails);
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
