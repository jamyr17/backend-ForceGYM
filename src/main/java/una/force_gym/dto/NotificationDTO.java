package una.force_gym.dto;

import java.util.Date;

public class NotificationDTO {
    
    private Long idNotification;
    private Long idUser;
    private Long idNotificationTemplate;
    private Date sendDate;
    private Long paramLoggedIdUser;

    public NotificationDTO() {}

    public NotificationDTO(Long idNotification, Long idUser, Long idNotificationTemplate, Date sendDate,
            Long paramLoggedIdUser) {
        this.idNotification = idNotification;
        this.idUser = idUser;
        this.idNotificationTemplate = idNotificationTemplate;
        this.sendDate = sendDate;
        this.paramLoggedIdUser = paramLoggedIdUser;
    }
    public Long getIdNotification() {
        return idNotification;
    }
    public void setIdNotification(Long idNotification) {
        this.idNotification = idNotification;
    }
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public Long getIdNotificationTemplate() {
        return idNotificationTemplate;
    }
    public void setIdNotificationTemplate(Long idNotificationTemplate) {
        this.idNotificationTemplate = idNotificationTemplate;
    }
    public Date getSendDate() {
        return sendDate;
    }
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
    public Long getParamLoggedIdUser() {
        return paramLoggedIdUser;
    }
    public void setParamLoggedIdUser(Long paramLoggedIdUser) {
        this.paramLoggedIdUser = paramLoggedIdUser;
    } 
}
