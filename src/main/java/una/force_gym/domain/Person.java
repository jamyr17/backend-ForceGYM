package una.force_gym.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbPerson")
public class Person {
    
    @Id
    @Column(name = "IdPerson")
    private Long idPerson;

    @Column(name = "name")
    private String name;

    @Column(name = "firstLastName")
    private String firstLastName;

    @Column(name = "secondLastName")
    private String secondLastName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "identificationNumber")
    private String identificationNumber;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    public Person(){}

    public Person(Long idPerson, String name, String firstLastName, String secondLastName, LocalDate birthday,
                  String identificationNumber, String phoneNumber, String email, String gender) {
        this.idPerson = idPerson;
        this.name = name;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.birthday = birthday;
        this.identificationNumber = identificationNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
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

    public void setIdentificationNumber(String identificatioNumber) {
        this.identificationNumber = identificatioNumber;
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
    
}
