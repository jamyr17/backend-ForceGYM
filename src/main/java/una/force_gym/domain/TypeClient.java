package una.force_gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbTypeClient")
public class TypeClient {

    @Id
    @Column(name = "idTypeClient")
    private Long idTypeClient;

    @Column(name = "name")
    private String name;

    @Column(name = "dailyCharge")
    private Float dailyCharge;

    @Column(name = "weeklyCharge")
    private Float weeklyCharge;

    @Column(name = "biweeklyCharge")
    private Float biweeklyCharge;

    @Column(name = "monthlyCharge")
    private Float monthlyCharge;

    @Column(name = "isDeleted")
    private Long isDeleted;

    public TypeClient() {}

    public TypeClient(Long idTypeClient, String name, Float dailyCharge, Float weeklyCharge, Float biweeklyCharge, Float monthlyCharge, Long isDeleted) {
        this.idTypeClient = idTypeClient;
        this.name = name;
        this.dailyCharge = dailyCharge;
        this.weeklyCharge = weeklyCharge;
        this.biweeklyCharge = biweeklyCharge;
        this.monthlyCharge = monthlyCharge;
        this.isDeleted = isDeleted;
    }

    public Long getIdTypeClient() {
        return idTypeClient;
    }

    public void setIdTypeClient(Long idTypeClient) {
        this.idTypeClient = idTypeClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getDailyCharge() {
        return dailyCharge;
    }

    public void setDailyCharge(Float dailyCharge) {
        this.dailyCharge = dailyCharge;
    }

    public Float getWeeklyCharge() {
        return weeklyCharge;
    }

    public void setWeeklyCharge(Float weeklyCharge) {
        this.weeklyCharge = weeklyCharge;
    }

    public Float getBiweeklyCharge() {
        return biweeklyCharge;
    }

    public void setBiweeklyCharge(Float biweeklyCharge) {
        this.biweeklyCharge = biweeklyCharge;
    }

    public Float getMonthlyCharge() {
        return monthlyCharge;
    }

    public void setMonthlyCharge(Float monthlyCharge) {
        this.monthlyCharge = monthlyCharge;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }
}
