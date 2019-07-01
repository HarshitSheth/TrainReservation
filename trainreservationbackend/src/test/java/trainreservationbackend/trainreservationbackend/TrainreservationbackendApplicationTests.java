package trainreservationbackend.trainreservationbackend;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import trainreservationbackend.trainreservationbackend.model.ClassDetails;
import trainreservationbackend.trainreservationbackend.model.Login;
import trainreservationbackend.trainreservationbackend.service.ServiceClass;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainreservationbackendApplicationTests {

    @Autowired
    ServiceClass serviceClass;

    @Test
    public void checkUserValidation(){
        Login login = new Login();
        login.setUsername("hsheth");
        login.setPassword("Harshit1@");

        Login loginName = serviceClass.loginUser(login);
        Assert.assertEquals("harshit", loginName.getName());
    }

    @Test
    public void checkUserRegistration(){
        Login login = new Login();
        login.setUsername("username");
        login.setName("name");
        login.setPassword("abcd");
        login.setConfirmpassword("abcd");
        login.setEmail("email@email.com");

        Assert.assertTrue(serviceClass.validateUser(login));

    }

    @Test
    public void validatePassengerDetails(){
        ClassDetails classDetails = serviceClass.getPassengerDetails("10");
        Assert.assertNotNull(classDetails);
    }

    @Test
    public void validateCancelReservation(){
        Assert.assertTrue(serviceClass.cancelReservation("10"));

    }

    @Test
    public void validateBookReservation(){
        ClassDetails classdetails = new ClassDetails();
        classdetails.setPassengername("harshit");
        classdetails.setPassengerage("20");
        classdetails.setClassname("general");

        Assert.assertNotNull(serviceClass.bookReservation(classdetails));
    }

}
