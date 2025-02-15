package una.force_gym.dto;

import java.util.Date;

public class ClientDTO {
    
    private Long idClient;
    private Long idPerson;
    private Long idTypeClient;
    private Long idHealthQuestionnaire;
    private Long idUser;
    private Date registrationDate;
    private String emergencyContact;
    private String signatureImage;
    private Long paramLoggedIdUser;

    public ClientDTO() {}

    public ClientDTO(Long idClient, Long idPerson, Long idTypeClient, Long idHealthQuestionnaire,
                     Long idUser, Date registrationDate, String emergencyContact, String signatureImage, Long paramLoggedIdUser) {
        this.idClient = idClient;
        this.idPerson = idPerson;
        this.idTypeClient = idTypeClient;
        this.idHealthQuestionnaire = idHealthQuestionnaire;
        this.idUser = idUser;
        this.registrationDate = registrationDate;
        this.emergencyContact = emergencyContact;
        this.signatureImage = signatureImage;
        this.paramLoggedIdUser = paramLoggedIdUser;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public Long getIdTypeClient() {
        return idTypeClient;
    }

    public void setIdTypeClient(Long idTypeClient) {
        this.idTypeClient = idTypeClient;
    }

    public Long getIdHealthQuestionnaire() {
        return idHealthQuestionnaire;
    }

    public void setIdHealthQuestionnaire(Long idHealthQuestionnaire) {
        this.idHealthQuestionnaire = idHealthQuestionnaire;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getSignatureImage() {
        return signatureImage;
    }

    public void setSignatureImage(String signatureImage) {
        this.signatureImage = signatureImage;
    }

    public Long getParamLoggedIdUser() {
        return paramLoggedIdUser;
    }

    public void setParamLoggedIdUser(Long paramLoggedIdUser) {
        this.paramLoggedIdUser = paramLoggedIdUser;
    }
}
