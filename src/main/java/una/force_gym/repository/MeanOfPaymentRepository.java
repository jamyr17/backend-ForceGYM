package una.force_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import una.force_gym.domain.MeanOfPayment;

public interface MeanOfPaymentRepository extends JpaRepository<MeanOfPayment, Long> {
    
    @Procedure(procedureName = "prGetMeanOfPayment")
    List<MeanOfPayment> getMeansOfPayment(); 

}
