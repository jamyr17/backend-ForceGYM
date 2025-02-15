package una.force_gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import una.force_gym.domain.Client;

import java.util.Date;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Procedure(procedureName = "prGetClients")
    List<Client> getClients(@Param("p_page") int p_page, @Param("p_limit") int p_limit);

    Long countByIsDeleted(Long isDeleted);

    @Procedure(procedureName = "prInsertClient", outputParameterName = "result")
    int addClient(
        @Param("pIdPerson") Long pIdPerson, 
        @Param("pIdTypeClient") Long pIdTypeClient, 
        @Param("pIdHealthQuestionnaire") Long pIdHealthQuestionnaire, 
        @Param("pIdUser") Long pIdUser, 
        @Param("pRegistrationDate") Date registrationDate, 
        @Param("pEmergencyContact") String pEmergencyContact, 
        @Param("pSignatureImage") String pSignatureImage, 
        @Param("pLoggedIdUser") Long pLoggedIdUser
    );

    @Procedure(procedureName = "prUpdateClient", outputParameterName = "result")
    int updateClient(
        @Param("pIdClient") Long pIdClient, 
        @Param("pIdPerson") Long pIdPerson, 
        @Param("pIdTypeClient") Long pIdTypeClient, 
        @Param("pIdHealthQuestionnaire") Long pIdHealthQuestionnaire, 
        @Param("pIdUser") Long pIdUser, 
        @Param("pRegistrationDate") Date registrationDate, 
        @Param("pEmergencyContact") String pEmergencyContact, 
        @Param("pSignatureImage") String pSignatureImage, 
        @Param("pLoggedIdUser") Long pLoggedIdUser
    );

    @Procedure(procedureName = "prDeleteClient", outputParameterName = "result")
    int deleteClient(@Param("pIdClient") Long pIdClient, @Param("pLoggedIdUser") Long pLoggedIdUser);
}
