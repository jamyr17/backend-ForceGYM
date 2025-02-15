package una.force_gym.dto;

public class TypeClientDTO {

    private Long idTypeClient;
    private String name;
    private Float dailyCharge;
    private Float weeklyCharge;
    private Float biweeklyCharge;
    private Float monthlyCharge;
    private Long paramLoggedIdUser;

    public TypeClientDTO() {}


    public TypeClientDTO(Long idTypeClient, String name, Float dailyCharge, Float weeklyCharge, Float biweeklyCharge,
            Float monthlyCharge, Long paramLoggedIdUser) {
        this.idTypeClient = idTypeClient;
        this.name = name;
        this.dailyCharge = dailyCharge;
        this.weeklyCharge = weeklyCharge;
        this.biweeklyCharge = biweeklyCharge;
        this.monthlyCharge = monthlyCharge;
        this.paramLoggedIdUser = paramLoggedIdUser;
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

    public Long getParamLoggedIdUser() {
        return paramLoggedIdUser;
    }

    public void setParamLoggedIdUser(Long paramLoggedIdUser) {
        this.paramLoggedIdUser = paramLoggedIdUser;
    }
    
}
