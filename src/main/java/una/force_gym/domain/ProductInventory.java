package una.force_gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbProductInventory")
public class ProductInventory {
    
    @Id
    @Column(name = "idProductInventory")
    private Long idProductInventory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    private User user;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "cost")
    private Float cost;

    @Column(name = "isDeleted")
    private Long isDeleted;

    public ProductInventory() {}

    public ProductInventory(String code, Float cost, Long idProductInventory, String name, int quantity, User user, Long isDeleted) {
        this.code = code;
        this.cost = cost;
        this.idProductInventory = idProductInventory;
        this.name = name;
        this.quantity = quantity;
        this.user = user;
        this.isDeleted = isDeleted;
    }

    public Long getIdProductInventory() {
        return idProductInventory;
    }

    public void setIdProductInventory(Long idProductInventory) {
        this.idProductInventory = idProductInventory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public Long getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Long isDeleted) {
        this.isDeleted = isDeleted;
    }

}
