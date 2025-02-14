package una.force_gym.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.domain.EconomicExpense;

public interface EconomicExpenseRepository extends JpaRepository<EconomicExpense, Long>{

    @Procedure(procedureName = "prGetEconomicExpense")
    List<EconomicExpense> getEconomicExpenses(@Param("p_page") int p_page, @Param("p_limit") int p_limit);

    Long countByIsDeleted(Long isDeleted);

    @Procedure(procedureName = "prInsertEconomicExpense", outputParameterName = "result")
    int addEconomicExpense(@Param("pIdUser") Long pIdUser, @Param("pRegistrationDate") LocalDate pRegistrationDate, @Param("pVoucherNumber") String pVoucherNumber, @Param("pDetail") String pDetail, @Param("pIdMeanOfPayment") Long pIdMeanOfPayment, @Param("pAmount") Float pAmount, @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prUpdateEconomicExpense", outputParameterName = "result")
    int updateEconomicExpense(@Param("pIdEconomicExpense") Long pIdEconomicExpense, @Param("pIdUser") Long pIdUser, @Param("pRegistrationDate") LocalDate pRegistrationDate, @Param("pVoucherNumber") String pVoucherNumber, @Param("pDetail") String pDetail, @Param("pIdMeanOfPayment") Long pIdMeanOfPayment, @Param("pAmount") Float pAmount, @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prDeleteEconomicExpense")
    int deleteEconomicExpense(@Param("pIdEconomicExpense") Long pIdEconomicExpense, @Param("pLoggedIdUser") Long pLoggedIdUser);
    
    @Procedure(procedureName = "prGetEconomicExpenseByAmountRange")
    List<EconomicExpense> getEconomicExpensesByAmountRange(@Param("minAmount") double minAmount, @Param("maxAmount") double maxAmount, @Param("p_page") int p_page, @Param("p_limit") int p_limit);

    @Procedure(procedureName = "prGetEconomicExpenseByDateRange")
    List<EconomicExpense> getEconomicExpensesByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, @Param("p_page") int p_page, @Param("p_limit") int p_limit);

    @Query("SELECT COUNT(e) FROM EconomicExpense e WHERE e.registrationDate >= :startDate AND e.registrationDate <= :endDate AND e.isDeleted = 0")
    Long countEconomicExpensesByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
    
    @Query("SELECT COUNT(e) FROM EconomicExpense e WHERE e.amount >= :minAmount AND e.amount <= :maxAmount AND e.isDeleted = 0")
    Long countEconomicExpensesByAmountRange(@Param("minAmount") double minAmount, @Param("maxAmount") double maxAmount);

    @Query(value = "SELECT * FROM tbeconomicexpense p WHERE p.isDeleted = 0 AND " +
               "LOWER(p.vouchernumber) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
               "LIMIT :size OFFSET :offset", nativeQuery = true)
    List<EconomicExpense> searchEconomicExpenses(@Param("searchTerm") String searchTerm, @Param("offset") int offset, @Param("size") int size);

    @Query(value = "SELECT COUNT(*) FROM tbeconomicexpense p WHERE p.isDeleted = 0 AND " +
                "LOWER(p.vouchernumber) LIKE LOWER(CONCAT('%', :searchTerm, '%'))", nativeQuery = true)
    Long countBySearchTerm(@Param("searchTerm") String searchTerm);

}
