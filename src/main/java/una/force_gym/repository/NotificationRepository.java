package una.force_gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

import una.force_gym.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    
    @Procedure(procedureName = "prGetNotification")
    List<Notification> getNotifications(@Param("p_page") int p_page, @Param("p_limit") int p_limit);

    Long countByIsDeleted(Long isDeleted);

    @Procedure(procedureName = "prInsertNotification", outputParameterName = "result")
    int addNotification(
        @Param("pIdUser") Long pIdUser,
        @Param("pIdNotificationTemplate") Long pIdNotificationTemplate,
        @Param("pSendDate") Date pSendDate,
        @Param("pLoggedIdUser") Long pLoggedIdUser
    );

    @Procedure(procedureName = "prUpdateNotification", outputParameterName = "result")
    int updateNotification(
        @Param("pIdNotification") Long pIdNotification,
        @Param("pIdUser") Long pIdUser,
        @Param("pIdNotificationTemplate") Long pIdNotificationTemplate,
        @Param("pSendDate") Date pSendDate,
        @Param("pLoggedIdUser") Long pLoggedIdUser
    );

    @Procedure(procedureName = "prDeleteNotification", outputParameterName = "result")
    int deleteNotification(  @Param("pIdNotification") Long pIdNotification, 
                                    @Param("pLoggedIdUser") Long pLoggedIdUser);
}
