package una.force_gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbRole")
public class Role {

    @Id
    @Column(name = "idRole")
    private Long idRole;

    @Column(name = "name")
    private String name;

    public Role(){}

    public Role(Long idRole, String name) {
        this.idRole = idRole;
        this.name = name;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
