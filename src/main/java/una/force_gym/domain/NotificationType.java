package una.force_gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbNotificationType")
public class NotificationType {

    @Id
    @Column(name = "idNotificationType")
    private Long idNotificationType;

    @Column(name = "name")
    private String name;

    @Column(name = "isDeleted")
    private Long isDeleted;

    public NotificationType() {}

    public NotificationType(Long idNotificationType, String name, Long isDeleted) {
        this.idNotificationType = idNotificationType;
        this.name = name;
        this.isDeleted = isDeleted;
    }

    public Long getIdNotificationType() {
        return idNotificationType;
    }

    public void setIdNotificationType(Long idNotificationType) {
        this.idNotificationType = idNotificationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }
}
