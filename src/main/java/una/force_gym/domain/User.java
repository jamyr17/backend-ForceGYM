package una.force_gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbUser")
public class User {

    @Id
    @Column(name = "idUser")
    private Long idUser;

    @Column(name = "idPerson")
    private Long idPerson;

    @Column(name = "idRole")
    private Long idRole;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public User(){}

    public User(Long idUser, Long idPerson, Long idRole, String username, String password) {
        this.idUser = idUser;
        this.idPerson = idPerson;
        this.idRole = idRole;
        this.username = username;
        this.password = password;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
