package una.force_gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.domain.TypeClient;

import java.util.List;

public interface TypeClientRepository extends JpaRepository<TypeClient, Long> {

    @Procedure(procedureName = "prGetTypeClients")
    List<TypeClient> getTypeClients(@Param("p_page") int p_page, @Param("p_limit") int p_limit);

    Long countByIsDeleted(Long isDeleted);

    @Procedure(procedureName = "prInsertTypeClient", outputParameterName = "result")
    int addTypeClient(
        @Param("pTypeName") String pTypeName, 
        @Param("pDailyCharge") Float pDailyCharge, 
        @Param("pWeeklyCharge") Float pWeeklyCharge, 
        @Param("pBiweeklyCharge") Float pBiweeklyCharge, 
        @Param("pMonthlyCharge") Float pMonthlyCharge, 
        @Param("pLoggedIdUser") Long pLoggedIdUser
    );

    @Procedure(procedureName = "prUpdateTypeClient", outputParameterName = "result")
    int updateTypeClient(
        @Param("pIdTypeClient") Long pIdTypeClient, 
        @Param("pTypeName") String pTypeName, 
        @Param("pDailyCharge") Float pDailyCharge, 
        @Param("pWeeklyCharge") Float pWeeklyCharge, 
        @Param("pBiweeklyCharge") Float pBiweeklyCharge, 
        @Param("pMonthlyCharge") Float pMonthlyCharge, 
        @Param("pLoggedIdUser") Long pLoggedIdUser
    );

    @Procedure(procedureName = "prDeleteTypeClient", outputParameterName = "result")
    int deleteTypeClient(
        @Param("pIdTypeClient") Long pIdTypeClient, 
        @Param("pLoggedIdUser") Long pLoggedIdUser
    );
}
