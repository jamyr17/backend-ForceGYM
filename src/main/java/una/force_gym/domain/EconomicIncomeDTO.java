package una.force_gym.domain;

import java.time.LocalDate;

public class EconomicIncomeDTO {

    private Long idEconomicIncome;
    private Long idUser;
    private LocalDate registrationDate;
    private String voucherNumber;
    private String detail;
    private String meanOfPayment;
    private Float amount;
    private String activityType;
    private Long paramLoggedIdUser;

    public EconomicIncomeDTO() {}

    public EconomicIncomeDTO(Long idEconomicIncome, Long idUser, LocalDate registrationDate, String voucherNumber, String detail, String meanOfPayment, Float amount, String activityType, Long paramLoggedIdUser) {
        this.idEconomicIncome = idEconomicIncome;
        this.idUser = idUser;
        this.registrationDate = registrationDate;
        this.voucherNumber = voucherNumber;
        this.detail = detail;
        this.meanOfPayment = meanOfPayment;
        this.amount = amount;
        this.activityType = activityType;
        this.paramLoggedIdUser = paramLoggedIdUser;
    }

    public Long getIdEconomicIncome() {
        return idEconomicIncome;
    }

    public void setIdEconomicIncome(Long idEconomicIncome) {
        this.idEconomicIncome = idEconomicIncome;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMeanOfPayment() {
        return meanOfPayment;
    }

    public void setMeanOfPayment(String meanOfPayment) {
        this.meanOfPayment = meanOfPayment;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Long getParamLoggedIdUser() {
        return paramLoggedIdUser;
    }

    public void setParamnLoggedIdUser(Long paramLoggedIdUser) {
        this.paramLoggedIdUser = paramLoggedIdUser;
    }

}
