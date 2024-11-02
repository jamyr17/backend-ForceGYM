package una.force_gym.dto;

public class ProductInventoryDTO {

    private Long idProductInventory;
    private Long idUser;
    private String code;
    private String name;
    private int quantity;
    private Float cost;
    private Long paramLoggedIdUser;

    public ProductInventoryDTO() {}

    public ProductInventoryDTO(String code, Float cost, Long idProductInventory, Long idUser, String name, int quantity, Long paramLoggedIdUser) {
        this.code = code;
        this.cost = cost;
        this.idProductInventory = idProductInventory;
        this.idUser = idUser;
        this.name = name;
        this.quantity = quantity;
        this.paramLoggedIdUser = paramLoggedIdUser;
    }

    public Long getIdProductInventory() {
        return idProductInventory;
    }

    public void setIdProductInventory(Long idProductInventory) {
        this.idProductInventory = idProductInventory;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Long getParamLoggedIdUser() {
        return paramLoggedIdUser;
    }

    public void setParamLoggedIdUser(Long paramLoggedIdUser) {
        this.paramLoggedIdUser = paramLoggedIdUser;
    }

}
