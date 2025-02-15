package una.force_gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import una.force_gym.dto.ClientDTO;
import una.force_gym.repository.ClientRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> getClients(
        int page, 
        int size, int searchType, 
        String searchTerm, 
        String orderBy, 
        String directionOrderBy, 
        String filterByStatus
    ) {
            
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("prGetClient", ClientDTO.class);
        
        // Parámetros de entrada
        query.registerStoredProcedureParameter("p_page", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_limit", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_searchType", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_searchTerm", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_orderBy", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_directionOrderBy", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByStatus", String.class, ParameterMode.IN);

        // Parámetro de salida
        query.registerStoredProcedureParameter("p_totalRecords", Integer.class, ParameterMode.OUT);

        // Setear valores
        query.setParameter("p_page", page);
        query.setParameter("p_limit", size);
        query.setParameter("p_searchType", searchType);
        query.setParameter("p_searchTerm", searchTerm);
        query.setParameter("p_orderBy", orderBy);
        query.setParameter("p_directionOrderBy", directionOrderBy);
        query.setParameter("p_filterByStatus", filterByStatus);

        // Ejecutar procedimiento
        query.execute();

        // Obtener los resultados
        List<ClientDTO> products = query.getResultList();
        Integer totalRecords = (Integer) query.getOutputParameterValue("p_totalRecords");

        // Mapear respuesta
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("clients", products);
        responseData.put("totalRecords", totalRecords);
        
        return responseData;
    }
    @Transactional
    public int addClient(Long idPerson, Long idTypeClient, Long idHealthQuestionnaire, Long idUser,
                         Date registrationDate, String emergencyContact, String signatureImage, Long pLoggedIdUser) {
        return clientRepo.addClient(idPerson, idTypeClient, idHealthQuestionnaire, idUser, 
                         registrationDate, emergencyContact, signatureImage, pLoggedIdUser);
    }

    @Transactional
    public int updateClient(Long idClient, Long idPerson, Long idTypeClient, Long idHealthQuestionnaire, Long idUser,
                         Date registrationDate, String emergencyContact, String signatureImage, Long pLoggedIdUser) {
        return clientRepo.updateClient(idClient, idPerson, idTypeClient, idHealthQuestionnaire, idUser, registrationDate, emergencyContact, signatureImage, pLoggedIdUser);
    }

    @Transactional
    public int deleteClient(Long idClient, Long pLoggedIdUser) {
        return clientRepo.deleteClient(idClient, pLoggedIdUser);
    }
}
