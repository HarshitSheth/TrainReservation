package trainreservationbackend.trainreservationbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import trainreservationbackend.trainreservationbackend.model.ClassDetails;

public interface ClassDetailsDao extends JpaRepository<ClassDetails, String> {
}
