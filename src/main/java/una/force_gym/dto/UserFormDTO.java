package una.force_gym.dto;

import java.time.LocalDate;

public class UserFormDTO {

    private Long idUser;
    private Long idRole;
    private Long idPerson;
    private String name;
    private String firstLastName;
    private String secondLastName;
    private LocalDate birthday;
    private String identificationNumber;
    private String phoneNumber;
    private String email;
    private String gender;
    private String username;
    private String password;
    private Long paramLoggedIdUser;

    public UserFormDTO(){}

    public UserFormDTO(Long idUser, Long idRole, Long idPerson, String name, String firstLastName, String secondLastName, LocalDate birthday, String identificationNumber, String phoneNumber, String email, String gender, String username, String password, Long paramLoggedIdUser) {
        this.birthday = birthday;
        this.idPerson = idPerson;
        this.idRole = idRole;
        this.email = email;
        this.firstLastName = firstLastName;
        this.gender = gender;
        this.idUser = idUser;
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.paramLoggedIdUser = paramLoggedIdUser;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.secondLastName = secondLastName;
        this.username = username;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public void setParamLoggedIdUser(Long paramLoggedIdUser) {
        this.paramLoggedIdUser = paramLoggedIdUser;
    }

    

}
