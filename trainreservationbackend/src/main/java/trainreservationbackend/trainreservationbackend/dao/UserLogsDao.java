package trainreservationbackend.trainreservationbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import trainreservationbackend.trainreservationbackend.model.UserLogs;

public interface UserLogsDao extends JpaRepository<UserLogs, Integer> {
}
