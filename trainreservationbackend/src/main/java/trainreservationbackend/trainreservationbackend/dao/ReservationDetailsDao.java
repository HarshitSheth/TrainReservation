package trainreservationbackend.trainreservationbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import trainreservationbackend.trainreservationbackend.model.ReservationDetails;

public interface ReservationDetailsDao extends JpaRepository<ReservationDetails, String> {
}
