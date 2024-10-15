package una.force_gym.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbMeanOfPayment")
public class MeanOfPayment {
    
    @Id
    @Column(name = "idMeanOfPayment")
    private Long idMeanOfPayment;

    @Column(name = "name")
    private String name;

    public MeanOfPayment() {}

    public MeanOfPayment(Long idMeanOfPayment, String name) {
        this.idMeanOfPayment = idMeanOfPayment;
        this.name = name;
    }

    public Long getIdMeanOfPayment() {
        return idMeanOfPayment;
    }

    public void setIdMeanOfPayment(Long idMeanOfPayment) {
        this.idMeanOfPayment = idMeanOfPayment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
