package una.force_gym.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbEconomicExpense")
public class EconomicExpense {

    @Id
    @Column(name = "idEconomicExpense")
    private Long idEconomicExpense;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    private User user;

    @Column(name = "registrationDate")
    private LocalDate registrationDate;

    @Column(name = "voucherNumber")
    private String voucherNumber;

    @Column(name = "detail")
    private String detail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idMeanOfPayment", referencedColumnName = "idMeanOfPayment")
    private MeanOfPayment meanOfPayment;

    @Column(name = "amount")
    private Float amount;

    public EconomicExpense (){}
    
    public EconomicExpense(Long idEconomicExpense, User user, LocalDate registrationDate, String voucherNumber, String detail, MeanOfPayment meanOfPayment, Float amount) {
        this.idEconomicExpense = idEconomicExpense;
        this.user = user;
        this.registrationDate = registrationDate;
        this.voucherNumber = voucherNumber;
        this.detail = detail;
        this.meanOfPayment = meanOfPayment;
        this.amount = amount;
    }

    public Long getIdEconomicExpense() {
        return idEconomicExpense;
    }

    public void setIdEconomicExpense(Long idEconomicExpense) {
        this.idEconomicExpense = idEconomicExpense;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public MeanOfPayment getMeanOfPayment() {
        return meanOfPayment;
    }

    public void setMeanOfPayment(MeanOfPayment meanOfPayment) {
        this.meanOfPayment = meanOfPayment;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

}
