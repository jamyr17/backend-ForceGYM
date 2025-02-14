package una.force_gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tbMeasurement")
public class Measurement {

    @Id
    @Column(name = "idMeasurement")
    private Long idMeasurement;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    private Client client;

    @Column(name = "measurementDate")
    private Date measurementDate;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "height")
    private Float height;

    @Column(name = "muscleMass")
    private Float muscleMass;

    @Column(name = "bodyFatPercentage")
    private Float bodyFatPercentage;

    @Column(name = "visceralFatPercentage")
    private Float visceralFatPercentage;

    @Column(name = "neckSize")
    private Float neckSize;

    @Column(name = "shoulderSize")
    private Float shoulderSize;

    @Column(name = "chestSize")
    private Float chestSize;

    @Column(name = "waistSize")
    private Float waistSize;

    @Column(name = "thighSize")
    private Float thighSize;

    @Column(name = "calfSize")
    private Float calfSize;

    @Column(name = "forearmSize")
    private Float forearmSize;

    @Column(name = "armSize")
    private Float armSize;

    @Column(name = "isDeleted")
    private Long isDeleted;

    public Measurement() {}

    public Measurement(Long idMeasurement, Client client, Date measurementDate, Float weight, Float height, Float muscleMass, 
                       Float bodyFatPercentage, Float visceralFatPercentage, Float neckSize, Float shoulderSize, Float chestSize, 
                       Float waistSize, Float thighSize, Float calfSize, Float forearmSize, Float armSize, Long isDeleted) {
        this.idMeasurement = idMeasurement;
        this.client = client;
        this.measurementDate = measurementDate;
        this.weight = weight;
        this.height = height;
        this.muscleMass = muscleMass;
        this.bodyFatPercentage = bodyFatPercentage;
        this.visceralFatPercentage = visceralFatPercentage;
        this.neckSize = neckSize;
        this.shoulderSize = shoulderSize;
        this.chestSize = chestSize;
        this.waistSize = waistSize;
        this.thighSize = thighSize;
        this.calfSize = calfSize;
        this.forearmSize = forearmSize;
        this.armSize = armSize;
        this.isDeleted = isDeleted;
    }

    public Long getIdMeasurement() {
        return idMeasurement;
    }

    public void setIdMeasurement(Long idMeasurement) {
        this.idMeasurement = idMeasurement;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getMeasurementDate() {
        return measurementDate;
    }

    public void setMeasurementDate(Date measurementDate) {
        this.measurementDate = measurementDate;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getMuscleMass() {
        return muscleMass;
    }

    public void setMuscleMass(Float muscleMass) {
        this.muscleMass = muscleMass;
    }

    public Float getBodyFatPercentage() {
        return bodyFatPercentage;
    }

    public void setBodyFatPercentage(Float bodyFatPercentage) {
        this.bodyFatPercentage = bodyFatPercentage;
    }

    public Float getVisceralFatPercentage() {
        return visceralFatPercentage;
    }

    public void setVisceralFatPercentage(Float visceralFatPercentage) {
        this.visceralFatPercentage = visceralFatPercentage;
    }

    public Float getNeckSize() {
        return neckSize;
    }

    public void setNeckSize(Float neckSize) {
        this.neckSize = neckSize;
    }

    public Float getShoulderSize() {
        return shoulderSize;
    }

    public void setShoulderSize(Float shoulderSize) {
        this.shoulderSize = shoulderSize;
    }

    public Float getChestSize() {
        return chestSize;
    }

    public void setChestSize(Float chestSize) {
        this.chestSize = chestSize;
    }

    public Float getWaistSize() {
        return waistSize;
    }

    public void setWaistSize(Float waistSize) {
        this.waistSize = waistSize;
    }

    public Float getThighSize() {
        return thighSize;
    }

    public void setThighSize(Float thighSize) {
        this.thighSize = thighSize;
    }

    public Float getCalfSize() {
        return calfSize;
    }

    public void setCalfSize(Float calfSize) {
        this.calfSize = calfSize;
    }

    public Float getForearmSize() {
        return forearmSize;
    }

    public void setForearmSize(Float forearmSize) {
        this.forearmSize = forearmSize;
    }

    public Float getArmSize() {
        return armSize;
    }

    public void setArmSize(Float armSize) {
        this.armSize = armSize;
    }

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }
}
