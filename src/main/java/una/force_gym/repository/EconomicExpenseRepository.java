package una.force_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.domain.EconomicExpense;

public interface EconomicExpenseRepository extends JpaRepository<EconomicExpense, Long>{

    @Procedure(procedureName = "prGetEconomicExpense")
    List<EconomicExpense> getEconomicExpenses(); 

    // procedure de add

    // procedure de update

    @Procedure(procedureName = "prDeleteEconomicExpense")
    int deleteEconomicExpense(@Param("pIdEconomicExpense") Long pIdEconomicExpense, @Param("pLoggedIdUser") Long pLoggedIdUser);
    
}
