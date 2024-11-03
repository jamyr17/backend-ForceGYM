package una.force_gym.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.domain.EconomicIncome;

public interface EconomicIncomeRepository extends JpaRepository<EconomicIncome, Long>{
    
    @Procedure(procedureName = "prGetEconomicIncome")
    List<EconomicIncome> getEconomicIncomes(@Param("p_page") int p_page, @Param("p_limit") int p_limit); 

    Long countByIsDeleted(Long isDeleted);

    @Procedure(procedureName = "prInsertEconomicIncome", outputParameterName = "result")
    int addEconomicIncome(@Param("pIdUser") Long pIdUser, @Param("pRegistrationDate") LocalDate pRegistrationDate, @Param("pVoucherNumber") String pVoucherNumber, @Param("pDetail") String pDetail, @Param("pIdMeanOfPayment") Long pIdMeanOfPayment, @Param("pAmount") Float pAmount, @Param("pIdActivityType") Long pIdActivityType, @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prUpdateEconomicIncome", outputParameterName = "result")
    int updateEconomicIncome(@Param("pIdEconomicIncome") Long pIdEconomicIncome, @Param("pIdUser") Long pIdUser, @Param("pRegistrationDate") LocalDate pRegistrationDate, @Param("pVoucherNumber") String pVoucherNumber, @Param("pDetail") String pDetail, @Param("pIdMeanOfPayment") Long pIdMeanOfPayment, @Param("pAmount") Float pAmount, @Param("pIdActivityType") Long pIdActivityType, @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prDeleteEconomicIncome")
    int deleteEconomicIncome(@Param("pIdEconomicIncome") Long pIdEconomicIncome, @Param("pLoggedIdUser") Long pLoggedIdUser);
    
}
