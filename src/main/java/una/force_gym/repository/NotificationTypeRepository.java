package una.force_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.domain.NotificationType;

public interface NotificationTypeRepository extends JpaRepository<NotificationType, Long> {
    
    @Procedure(procedureName = "prGetNotificationType")
    List<NotificationType> getNotificationTypes(@Param("p_page") int p_page, @Param("p_limit") int p_limit); 

    Long countByIsDeleted(Long isDeleted);

    @Procedure(procedureName = "prInsertNotificationType", outputParameterName = "result")
    int addNotificationType(@Param("pName") String pName, 
                            @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prUpdateNotificationType", outputParameterName = "result")
    int updateNotificationType( @Param("pIdNotificationType") Long pIdNotificationType, 
                                @Param("pName") String pName,
                                @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prDeleteNotificationType")
    int deleteNotificationType( @Param("pIdNotificationType") Long pIdNotificationType, 
                                @Param("pLoggedIdUser") Long pLoggedIdUser);
}
