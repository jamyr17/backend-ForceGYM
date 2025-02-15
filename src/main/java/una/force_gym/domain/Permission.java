package una.force_gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbPermission")
public class Permission {

    @Id
    @Column(name = "idPermission")
    private Long idPermission;

    @Column(name = "definition")
    private String definition;

    @Column(name = "description")
    private String description;

    @Column(name = "isDeleted")
    private Long isDeleted;

    public Permission() {}

    public Permission(Long idPermission, String definition, String description, Long isDeleted) {
        this.idPermission = idPermission;
        this.definition = definition;
        this.description = description;
        this.isDeleted = isDeleted;
    }

    public Long getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(Long idPermission) {
        this.idPermission = idPermission;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }
}
