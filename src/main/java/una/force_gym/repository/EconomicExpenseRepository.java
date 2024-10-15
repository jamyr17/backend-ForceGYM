package una.force_gym.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.domain.EconomicExpense;

public interface EconomicExpenseRepository extends JpaRepository<EconomicExpense, Long>{

    @Procedure(procedureName = "prGetEconomicExpense")
    List<EconomicExpense> getEconomicExpenses(); 

    @Procedure(procedureName = "prInsertEconomicExpense", outputParameterName = "result")
    int addEconomicExpense(@Param("pIdUser") Long pIdUser, @Param("pRegistrationDate") LocalDate pRegistrationDate, @Param("pVoucherNumber") String pVoucherNumber, @Param("pDetail") String pDetail, @Param("pIdMeanOfPayment") Long pIdMeanOfPayment, @Param("pAmount") Float pAmount, @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prUpdateEconomicExpense", outputParameterName = "result")
    int updateEconomicExpense(@Param("pIdEconomicExpense") Long pIdEconomicExpense, @Param("pIdUser") Long pIdUser, @Param("pRegistrationDate") LocalDate pRegistrationDate, @Param("pVoucherNumber") String pVoucherNumber, @Param("pDetail") String pDetail, @Param("pIdMeanOfPayment") Long pIdMeanOfPayment, @Param("pAmount") Float pAmount, @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prDeleteEconomicExpense")
    int deleteEconomicExpense(@Param("pIdEconomicExpense") Long pIdEconomicExpense, @Param("pLoggedIdUser") Long pLoggedIdUser);
    
}
