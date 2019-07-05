package trainreservationbackend.trainreservationbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import trainreservationbackend.trainreservationbackend.model.Login;

public interface LoginDao extends JpaRepository<Login, Integer> {
}
