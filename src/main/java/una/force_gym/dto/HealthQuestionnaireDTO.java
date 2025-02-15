package una.force_gym.dto;

public class HealthQuestionnaireDTO {

    private Long idHealthQuestionnaire;
    private Long idClient;
    private Boolean diabetes;
    private Boolean hypertension;
    private Boolean muscleInjuries;
    private Boolean boneJointIssues;
    private Boolean balanceLoss;
    private Boolean cardiovascularDisease;
    private Boolean breathingIssues;
    private Long paramLoggedIdUser;
    
    public HealthQuestionnaireDTO() {}

    public HealthQuestionnaireDTO(Long idHealthQuestionnaire, Long idClient, Boolean diabetes, Boolean hypertension,
            Boolean muscleInjuries, Boolean boneJointIssues, Boolean balanceLoss, Boolean cardiovascularDisease,
            Boolean breathingIssues, Long paramLoggedIdUser) {
        this.idHealthQuestionnaire = idHealthQuestionnaire;
        this.idClient = idClient;
        this.diabetes = diabetes;
        this.hypertension = hypertension;
        this.muscleInjuries = muscleInjuries;
        this.boneJointIssues = boneJointIssues;
        this.balanceLoss = balanceLoss;
        this.cardiovascularDisease = cardiovascularDisease;
        this.breathingIssues = breathingIssues;
        this.paramLoggedIdUser = paramLoggedIdUser;
    }

    public Long getIdHealthQuestionnaire() {
        return idHealthQuestionnaire;
    }

    public void setIdHealthQuestionnaire(Long idHealthQuestionnaire) {
        this.idHealthQuestionnaire = idHealthQuestionnaire;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
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

    public Long getParamLoggedIdUser() {
        return paramLoggedIdUser;
    }

    public void setParamLoggedIdUser(Long paramLoggedIdUser) {
        this.paramLoggedIdUser = paramLoggedIdUser;
    }
}
