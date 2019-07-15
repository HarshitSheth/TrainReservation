package trainreservationbackend.trainreservationbackend;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@EnableEncryptableProperties
@PropertySource(name="EncryptedProperties", value = "classpath:encrypted.properties")
@SpringBootApplication
public class TrainreservationbackendApplication {

    public static void main(String[] args) {
        System.setProperty("jasypt.encryptor.password","password");
        SpringApplication.run(TrainreservationbackendApplication.class, args);
    }

}
