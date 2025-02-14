package una.force_gym.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    
    @Procedure(procedureName = "prGetEconomicIncomeByAmountRange")
    List<EconomicIncome> getEconomicIncomesByAmountRange(@Param("minAmount") double minAmount, @Param("maxAmount") double maxAmount, @Param("p_page") int p_page, @Param("p_limit") int p_limit);

    @Procedure(procedureName = "prGetEconomicIncomeByDateRange")
    List<EconomicIncome> getEconomicIncomesByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("p_page") int p_page, @Param("p_limit") int p_limit);
    
    @Query("SELECT COUNT(e) FROM EconomicIncome e WHERE e.registrationDate >= :startDate AND e.registrationDate <= :endDate AND e.isDeleted = 0")
    Long countEconomicIncomesByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    
    @Query("SELECT COUNT(e) FROM EconomicIncome e WHERE e.amount >= :minAmount AND e.amount <= :maxAmount AND e.isDeleted = 0")
    Long countEconomicIncomesByAmountRange(@Param("minAmount") double minAmount, @Param("maxAmount") double maxAmount);

    @Query(value = "SELECT * FROM tbeconomicincome p WHERE p.isDeleted = 0 AND " +
               "LOWER(p.vouchernumber) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
               "LIMIT :size OFFSET :offset", nativeQuery = true)
    List<EconomicIncome> searchEconomicIncomes(@Param("searchTerm") String searchTerm, @Param("offset") int offset, @Param("size") int size);

    @Query(value = "SELECT COUNT(*) FROM tbeconomicincome p WHERE p.isDeleted = 0 AND " +
                "LOWER(p.vouchernumber) LIKE LOWER(CONCAT('%', :searchTerm, '%'))", nativeQuery = true)
    Long countBySearchTerm(@Param("searchTerm") String searchTerm);

}
