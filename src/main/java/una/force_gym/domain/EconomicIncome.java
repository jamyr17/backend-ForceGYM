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
@Table(name = "tbEconomicIncome")
public class EconomicIncome {

    @Id
    @Column(name = "idEconomicIncome")
    private Long idEconomicIncome;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idActivityType", referencedColumnName = "idActivityType")
    private ActivityType activityType;

    public EconomicIncome() {}

    public EconomicIncome(Long idEconomicIncome, User user, LocalDate registrationDate, String voucherNumber, String detail, MeanOfPayment meanOfPayment, Float amount, ActivityType activityType) {
        this.idEconomicIncome = idEconomicIncome;
        this.user = user;
        this.registrationDate = registrationDate;
        this.voucherNumber = voucherNumber;
        this.detail = detail;
        this.meanOfPayment = meanOfPayment;
        this.amount = amount;
        this.activityType = activityType;
    }

    public Long getIdEconomicIncome() {
        return idEconomicIncome;
    }

    public void setIdEconomicIncome(Long idEconomicIncome) {
        this.idEconomicIncome = idEconomicIncome;
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

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

}
