package una.force_gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import una.force_gym.domain.ActivityType;
import una.force_gym.repository.ActivityTypeRepository;

@Service
public class ActivityTypeService {

    @Autowired
    private ActivityTypeRepository activityTypeRepository;

    @Transactional
    public List<ActivityType> getActivityTypes(){
        return activityTypeRepository.getActivityTypes();
    }
    
}
