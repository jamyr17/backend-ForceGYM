package una.force_gym.dto;

import java.time.LocalDate;


public class EconomicExpenseDTO {

    private Long idEconomicExpense;
    private Long idUser;
    private LocalDate registrationDate;
    private String voucherNumber;
    private String detail;
    private Long idMeanOfPayment;
    private Float amount;
    private Long paramLoggedIdUser;

    public EconomicExpenseDTO (){}
    
    public EconomicExpenseDTO(Long idEconomicExpense, Long idUser, LocalDate registrationDate, String voucherNumber, String detail, Long idMeanOfPayment, Float amount, Long paramLoggedIdUser) {
        this.idEconomicExpense = idEconomicExpense;
        this.idUser = idUser;
        this.registrationDate = registrationDate;
        this.voucherNumber = voucherNumber;
        this.detail = detail;
        this.idMeanOfPayment = idMeanOfPayment;
        this.amount = amount;
        this.paramLoggedIdUser = paramLoggedIdUser;
    }

    public Long getIdEconomicExpense() {
        return idEconomicExpense;
    }

    public void setIdEconomicExpense(Long idEconomicExpense) {
        this.idEconomicExpense = idEconomicExpense;
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

    public Long getIdMeanOfPayment() {
        return idMeanOfPayment;
    }

    public void setIdMeanOfPayment(Long idMeanOfPayment) {
        this.idMeanOfPayment = idMeanOfPayment;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Long getParamLoggedIdUser() {
        return paramLoggedIdUser;
    }

    public void setParamLoggedIdUser(Long paramLoggedIdUser) {
        this.paramLoggedIdUser = paramLoggedIdUser;
    }

}
