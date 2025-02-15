package una.force_gym.dto;

import java.util.Date;

public class MeasurementDTO {
    
    private Long idMeasurement;
    private Long idClient;
    private Date measurementDate;
    private Float weight;
    private Float height;
    private Float muscleMass;
    private Float bodyFatPercentage;
    private Float visceralFatPercentage;
    private Float neckSize;
    private Float shoulderSize;
    private Float chestSize;
    private Float waistSize;
    private Float thighSize;
    private Float calfSize;
    private Float forearmSize;
    private Float armSize;
    private Long paramLoggedIdUser;

    public MeasurementDTO() {}

    public MeasurementDTO(Long idMeasurement, Long idClient, Date measurementDate, Float weight, Float height,
            Float muscleMass, Float bodyFatPercentage, Float visceralFatPercentage, Float neckSize, Float shoulderSize,
            Float chestSize, Float waistSize, Float thighSize, Float calfSize, Float forearmSize, Float armSize,
            Long paramLoggedIdUser) {
        this.idMeasurement = idMeasurement;
        this.idClient = idClient;
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
        this.paramLoggedIdUser = paramLoggedIdUser;
    }

    public Long getIdMeasurement() {
        return idMeasurement;
    }

    public void setIdMeasurement(Long idMeasurement) {
        this.idMeasurement = idMeasurement;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
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

    public Long getParamLoggedIdUser() {
        return paramLoggedIdUser;
    }

    public void setParamLoggedIdUser(Long paramLoggedIdUser) {
        this.paramLoggedIdUser = paramLoggedIdUser;
    }
}
