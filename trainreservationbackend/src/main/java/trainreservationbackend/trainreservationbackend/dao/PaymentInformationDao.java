package trainreservationbackend.trainreservationbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import trainreservationbackend.trainreservationbackend.model.PaymentInformation;

public interface PaymentInformationDao extends JpaRepository<PaymentInformation, Integer> {
}
