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

//@EnableEncryptableProperties
//@PropertySource(name="EncryptedProperties", value = "classpath:encrypted.properties")
@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainreservationbackendApplicationTests {

    @Autowired
    ServiceClass serviceClass;

    @Autowired
    PaymentInformationCRUDService paymentInformationCRUDService;


    @Test
    public void checkUserRegistration(){
        Login login = new Login();
        login.setUsername("username");
        login.setName("name");
        login.setPassword("abcd");
        login.setEmail("email@email.com");
        login.setContact("9999999999");
        Assert.assertTrue(serviceClass.validateUser(login));
    }

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
    public void validateBookReservation(){
        ReservationDetails classdetails = new ReservationDetails();
        classdetails.setPassengername("harshit");
        classdetails.setPassengerage("20");
        classdetails.setClassname("general");
        Assert.assertEquals(ReservationDetails.class, serviceClass.bookReservation(classdetails).getClass());
    }

    @Test
    public void validateFalseCancelReservation(){
        Assert.assertFalse(serviceClass.cancelReservation("40"));
    }


    @Test
    public void validateFalsePassengerDetails(){
        ReservationDetails reservationDetails = serviceClass.getPassengerDetails("40");
        Assert.assertNull(reservationDetails);
    }

    @Test
    public void validatePayment(){
        PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setCardholdername("jsdjh");
        paymentInformation.setPaymentamount(1000);
        Assert.assertTrue(paymentInformationCRUDService.saveToDB(paymentInformation));
    }

    //    @Test
//    public void validateTruePassengerDetails(){
//        ReservationDetails reservationDetails = serviceClass.getPassengerDetails("10");
//        Assert.assertEquals(ReservationDetails.class, reservationDetails.getClass());
//    }

    //    @Test
//    public void validateTrueCancelReservation(){
//        Assert.assertTrue(serviceClass.cancelReservation("10"));
//    }

}
