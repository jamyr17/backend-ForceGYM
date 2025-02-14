package una.force_gym.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import una.force_gym.domain.Notification;
import una.force_gym.repository.NotificationRepository;

@Service
public class NotificationService {
    
    @Autowired
    private NotificationRepository notificationRepo;

    public List<Notification> getNotifications(int page, int size) {
        return notificationRepo.getNotifications(page, size);
    }

    public Long countActiveNotifications() {
        return notificationRepo.countByIsDeleted(0L);
    }

    @Transactional
    public int addNotification( Long pIdUser, 
                                Long pIdNotificationTemplate,
                                Date pSendDate, 
                                Long pLoggedIdUser) {
        return notificationRepo.addNotification(pIdUser, 
                                                pIdNotificationTemplate, 
                                                pSendDate,
                                                pLoggedIdUser);
    }

    @Transactional
    public int updateNotification(  Long pIdNotification, 
                                    Long pIdUser, 
                                    Long pIdNotificationTemplate,
                                    Date pSendDate, 
                                    Long pLoggedIdUser) {
        return notificationRepo.updateNotification( pIdNotification, 
                                                    pIdUser,
                                                    pIdNotificationTemplate, 
                                                    pSendDate,
                                                    pLoggedIdUser);
    }

    @Transactional
    public int deleteNotification(  Long idNotification, 
                                            Long pLoggedIdUser){
        return notificationRepo.deleteNotification( idNotification, 
                                                                    pLoggedIdUser);
    }
}
