package una.force_gym.dto;

public class NotificationTemplateDTO {

    private Long idNotificationTemplate;
    private Long idNotificationType;
    private Long idUser;
    private String message;
    private Long paramLoggedIdUser;

    public NotificationTemplateDTO() {}

    public NotificationTemplateDTO(Long idNotificationTemplate, Long idNotificationType, Long idUser, String message,
            Long paramLoggedIdUser) {
        this.idNotificationTemplate = idNotificationTemplate;
        this.idNotificationType = idNotificationType;
        this.idUser = idUser;
        this.message = message;
        this.paramLoggedIdUser = paramLoggedIdUser;
    }

    public Long getIdNotificationTemplate() {
        return idNotificationTemplate;
    }

    public void setIdNotificationTemplate(Long idNotificationTemplate) {
        this.idNotificationTemplate = idNotificationTemplate;
    }

    public Long getIdNotificationType() {
        return idNotificationType;
    }

    public void setIdNotificationType(Long idNotificationType) {
        this.idNotificationType = idNotificationType;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getParamLoggedIdUser() {
        return paramLoggedIdUser;
    }

    public void setParamLoggedIdUser(Long paramLoggedIdUser) {
        this.paramLoggedIdUser = paramLoggedIdUser;
    }
}