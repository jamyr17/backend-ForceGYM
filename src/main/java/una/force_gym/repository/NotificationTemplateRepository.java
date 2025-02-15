package una.force_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.domain.NotificationTemplate;

public interface NotificationTemplateRepository extends JpaRepository<NotificationTemplate, Long> {
    
    @Procedure(procedureName = "prInsertNotificationTemplate", outputParameterName = "result")
    int addNotificationTemplate(@Param("pIdNotificationType") Long pIdNotificationType, 
                                @Param("pIdUser") Long pIdUser, 
                                @Param("pMessage") String pMessage, 
                                @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prUpdateNotificationTemplate", outputParameterName = "result")
    int updateNotificationTemplate( @Param("pIdNotificationTemplate") Long pIdNotificationTemplate, 
                                    @Param("pIdNotificationType") Long pIdNotificationType, 
                                    @Param("pIdUser") Long pIdUser, 
                                    @Param("pMessage") String pMessage, 
                                    @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prDeleteNotificationTemplate")
    int deleteNotificationTemplate( @Param("pIdNotificationTemplate") Long pIdNotificationTemplate, 
                                    @Param("pLoggedIdUser") Long pLoggedIdUser);
}
