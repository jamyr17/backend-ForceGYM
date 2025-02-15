package una.force_gym.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import una.force_gym.dto.PermissionDTO;
import una.force_gym.repository.PermissionRepository;

@Service
public class PermissionService {
    
    @Autowired
    private PermissionRepository permissionRepo;


    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> getPermissions(
        int page, 
        int size, int searchType, 
        String searchTerm, 
        String orderBy, 
        String directionOrderBy, 
        String filterByStatus
    ) {
            
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("prGetPermission", PermissionDTO.class);
        
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
        List<PermissionDTO> products = query.getResultList();
        Integer totalRecords = (Integer) query.getOutputParameterValue("p_totalRecords");

        // Mapear respuesta
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("permissions", products);
        responseData.put("totalRecords", totalRecords);
        
        return responseData;
    }

    @Transactional
    public int addPermission(   String pDefinition, 
    String pDescription,
    Long pLoggedIdUser) {
        return permissionRepo.addPermission(pDefinition, 
        pDescription, 
                                            pLoggedIdUser);
    }

    @Transactional
    public int updatePermission(Long pIdPermission, 
                                String pDefinition, 
                                String pDescription,
                                Long pLoggedIdUser) {
        return permissionRepo.updatePermission( pIdPermission,
                                                pDefinition, 
                                                pDescription, 
                                                pLoggedIdUser);
    }

    @Transactional
    public int deletePermission(Long idPermission, Long pLoggedIdUser){
        return permissionRepo.deletePermission(idPermission, pLoggedIdUser);
    }
}