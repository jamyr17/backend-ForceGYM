package una.force_gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbHealthQuestionnaire")
public class HealthQuestionnaire {

    @Id
    @Column(name = "idHealthQuestionnaire")
    private Long idHealthQuestionnaire;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    private Client client;

    @Column(name = "diabetes")
    private Boolean diabetes;

    @Column(name = "hypertension")
    private Boolean hypertension;

    @Column(name = "muscleInjuries")
    private Boolean muscleInjuries;

    @Column(name = "boneJointIssues")
    private Boolean boneJointIssues;

    @Column(name = "balanceLoss")
    private Boolean balanceLoss;

    @Column(name = "cardiovascularDisease")
    private Boolean cardiovascularDisease;

    @Column(name = "breathingIssues")
    private Boolean breathingIssues;

    @Column(name = "isDeleted")
    private Long isDeleted;

    public HealthQuestionnaire() {}

    public HealthQuestionnaire(Long idHealthQuestionnaire, Client client, Boolean diabetes, Boolean hypertension, Boolean muscleInjuries,
                               Boolean boneJointIssues, Boolean balanceLoss, Boolean cardiovascularDisease, Boolean breathingIssues, Long isDeleted) {
        this.idHealthQuestionnaire = idHealthQuestionnaire;
        this.client = client;
        this.diabetes = diabetes;
        this.hypertension = hypertension;
        this.muscleInjuries = muscleInjuries;
        this.boneJointIssues = boneJointIssues;
        this.balanceLoss = balanceLoss;
        this.cardiovascularDisease = cardiovascularDisease;
        this.breathingIssues = breathingIssues;
        this.isDeleted = isDeleted;
    }

    public Long getIdHealthQuestionnaire() {
        return idHealthQuestionnaire;
    }

    public void setIdHealthQuestionnaire(Long idHealthQuestionnaire) {
        this.idHealthQuestionnaire = idHealthQuestionnaire;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    public Boolean getHypertension() {
        return hypertension;
    }

    public void setHypertension(Boolean hypertension) {
        this.hypertension = hypertension;
    }

    public Boolean getMuscleInjuries() {
        return muscleInjuries;
    }

    public void setMuscleInjuries(Boolean muscleInjuries) {
        this.muscleInjuries = muscleInjuries;
    }

    public Boolean getBoneJointIssues() {
        return boneJointIssues;
    }

    public void setBoneJointIssues(Boolean boneJointIssues) {
        this.boneJointIssues = boneJointIssues;
    }

    public Boolean getBalanceLoss() {
        return balanceLoss;
    }

    public void setBalanceLoss(Boolean balanceLoss) {
        this.balanceLoss = balanceLoss;
    }

    public Boolean getCardiovascularDisease() {
        return cardiovascularDisease;
    }

    public void setCardiovascularDisease(Boolean cardiovascularDisease) {
        this.cardiovascularDisease = cardiovascularDisease;
    }

    public Boolean getBreathingIssues() {
        return breathingIssues;
    }

    public void setBreathingIssues(Boolean breathingIssues) {
        this.breathingIssues = breathingIssues;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }

    
}
