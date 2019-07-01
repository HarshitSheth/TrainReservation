package trainreservationbackend.trainreservationbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import trainreservationbackend.trainreservationbackend.model.ClassInformation;

public interface ClassInformationDao extends JpaRepository<ClassInformation, String> {
}
