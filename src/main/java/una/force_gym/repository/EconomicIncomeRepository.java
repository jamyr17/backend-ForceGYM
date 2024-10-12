package una.force_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.domain.EconomicIncome;

public interface EconomicIncomeRepository extends JpaRepository<EconomicIncome, Long>{
    
    @Procedure(procedureName = "prGetEconomicIncome")
    List<EconomicIncome> getEconomicIncomes(); 

    // procedure de add

    // procedure de update

    @Procedure(procedureName = "prDeleteEconomicIncome")
    int deleteEconomicIncome(@Param("pIdEconomicIncome") Long pIdEconomicIncome, @Param("pLoggedIdUser") Long pLoggedIdUser);
    
}
