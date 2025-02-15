package una.force_gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tbNotification")
public class Notification {

    @Id
    @Column(name = "idNotification")
    private Long idNotification;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idNotificationTemplate", referencedColumnName = "idNotificationTemplate")
    private NotificationTemplate notificationTemplate;

    @Column(name = "sendDate")
    private Date sendDate;

    @Column(name = "isDeleted")
    private Long isDeleted;

    public Notification() {}

    public Notification(Long idNotification, User user, NotificationTemplate notificationTemplate, Date sendDate, Long isDeleted) {
        this.idNotification = idNotification;
        this.user = user;
        this.notificationTemplate = notificationTemplate;
        this.sendDate = sendDate;
        this.isDeleted = isDeleted;
    }

    public Long getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Long idNotification) {
        this.idNotification = idNotification;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public NotificationTemplate getNotificationTemplate() {
        return notificationTemplate;
    }

    public void setNotificationTemplate(NotificationTemplate notificationTemplate) {
        this.notificationTemplate = notificationTemplate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }   
}