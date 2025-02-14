package una.force_gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbNotificationTemplate")
public class NotificationTemplate {

    @Id
    @Column(name = "idNotificationTemplate")
    private Long idNotificationTemplate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idNotificationType", referencedColumnName = "idNotificationType")
    private NotificationType notificationType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    private User user;

    @Column(name = "message")
    private String message;

    @Column(name = "isDeleted")
    private Long isDeleted;

    public NotificationTemplate() {}

    public NotificationTemplate(Long idNotificationTemplate, NotificationType notificationType, User user, String message, Long isDeleted) {
        this.idNotificationTemplate = idNotificationTemplate;
        this.notificationType = notificationType;
        this.user = user;
        this.message = message;
        this.isDeleted = isDeleted;
    }

    public Long getIdNotificationTemplate() {
        return idNotificationTemplate;
    }

    public void setIdNotificationTemplate(Long idNotificationTemplate) {
        this.idNotificationTemplate = idNotificationTemplate;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }
}
