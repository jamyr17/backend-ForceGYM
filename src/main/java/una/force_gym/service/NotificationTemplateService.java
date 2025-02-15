package una.force_gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import una.force_gym.domain.NotificationTemplate;
import una.force_gym.repository.NotificationTemplateRepository;

@Service
public class NotificationTemplateService {

    @Autowired
    private NotificationTemplateRepository notificationTemplateRepo;

    public List<NotificationTemplate> getNotificationTemplates(int page, int size) {
        return notificationTemplateRepo.getNotificationTemplates(page, size);
    }

    public Long countActiveNotificationTemplates() {
        return notificationTemplateRepo.countByIsDeleted(0L);
    }

    @Transactional
    public int addNotificationTemplate( Long pIdNotificationType, 
                                        Long pIdUser, 
                                        String pMessage, 
                                        Long pLoggedIdUser) {
        return notificationTemplateRepo.addNotificationTemplate(pIdNotificationType, 
                                                                pIdUser, 
                                                                pMessage,
                                                                pLoggedIdUser);
    }

    @Transactional
    public int updateNotificationTemplate(  Long pIdNotificationTemplate, 
                                            Long pIdNotificationType, 
                                            Long pIdUser, 
                                            String pMessage,
                                            Long pLoggedIdUser) {
        return notificationTemplateRepo.updateNotificationTemplate( pIdNotificationTemplate, 
                                                                    pIdNotificationType, 
                                                                    pIdUser, 
                                                                    pMessage,
                                                                    pLoggedIdUser);
    }

    @Transactional
    public int deleteNotificationTemplate(  Long idNotificationTemplate, 
                                            Long pLoggedIdUser){
        return notificationTemplateRepo.deleteNotificationTemplate( idNotificationTemplate, 
                                                                    pLoggedIdUser);
    }
}
