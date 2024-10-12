package una.force_gym.domain;

public class UserDTO {

    private Long idUser;
    private Long idPerson;
    private Long idRole;
    private String username;
    private String password;
    private Long paramLoggedIdUser;

    public UserDTO(){}

    public UserDTO(Long idUser, Long idPerson, Long idRole, String username, String password, Long paramLoggedIdUser) {
        this.idUser = idUser;
        this.idPerson = idPerson;
        this.idRole = idRole;
        this.username = username;
        this.password = password;
        this.paramLoggedIdUser = paramLoggedIdUser;
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

    public Long getParamLoggedIdUser() {
        return paramLoggedIdUser;
    }

    public void setParamnLoggedIdUser(Long paramLoggedIdUser) {
        this.paramLoggedIdUser = paramLoggedIdUser;
    }

}
