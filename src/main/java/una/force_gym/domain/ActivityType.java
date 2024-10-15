package una.force_gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbActivityType")
public class ActivityType {

    @Id
    @Column(name = "idActivityType")
    private Long idActivityType;

    @Column(name = "name")
    private String name;

    public ActivityType() {}

    public ActivityType(Long idActivityType, String name) {
        this.idActivityType = idActivityType;
        this.name = name;
    }

    public Long getIdActivityType() {
        return idActivityType;
    }

    public void setIdActivityType(Long idActivityType) {
        this.idActivityType = idActivityType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
