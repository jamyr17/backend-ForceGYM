package una.force_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import una.force_gym.domain.ActivityType;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Long> {
    
    @Procedure(procedureName = "prGetActivityType")
    List<ActivityType> getActivityTypes(); 

}
