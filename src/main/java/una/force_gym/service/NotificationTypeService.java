package una.force_gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import una.force_gym.domain.NotificationType;
import una.force_gym.repository.NotificationTypeRepository;

@Service
public class NotificationTypeService {
    
    @Autowired
    private NotificationTypeRepository notificationTypeRepo;

    @Transactional
    public List<NotificationType> getNotificationTypes(int page, int size){
        return notificationTypeRepo.getNotificationTypes(page, size);
    }

    public Long countActiveIncomes(){
        return notificationTypeRepo.countByIsDeleted(Long.valueOf(0));
    }

    @Transactional
    public int addNotificationType( String pName, 
                                    Long pLoggedIdUser){
        return notificationTypeRepo.addNotificationType(pName,  
                                                        pLoggedIdUser);
    }

    @Transactional
    public int updateNotificationType(  Long pIdNotificationType, 
                                        String pName,
                                        Long pLoggedIdUser){
        return notificationTypeRepo.updateNotificationType( pIdNotificationType, 
                                                            pName, 
                                                            pLoggedIdUser);
    }

    @Transactional
    public int deleteNotificationType(Long pIdNotificationType, Long pLoggedIdUser){
        return notificationTypeRepo.deleteNotificationType(pIdNotificationType, pLoggedIdUser);
    }
}
