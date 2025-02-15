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

import una.force_gym.dto.ProductInventoryDTO;
import una.force_gym.repository.ProductInventoryRepository;

@Service
public class ProductInventoryService {

    @Autowired
    private ProductInventoryRepository productInventoryRepo;
    
    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> getProductsInventory(
        int page, 
        int size, int searchType, 
        String searchTerm, 
        String orderBy, 
        String directionOrderBy, 
        String filterByStatus,
        String filterByCostRangeMax,
        String filterByCostRangeMin,
        String filterByQuantityRangeMax,
        String filterByQuantityRangeMin
    ) {
            
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("prGetProductInventory", ProductInventoryDTO.class);
        
        // Parámetros de entrada
        query.registerStoredProcedureParameter("p_page", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_limit", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_searchType", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_searchTerm", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_orderBy", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_directionOrderBy", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByStatus", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByCostRangeMax", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByCostRangeMin", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByQuantityRangeMax", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByQuantityRangeMin", String.class, ParameterMode.IN);

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
        query.setParameter("p_filterByCostRangeMax", filterByCostRangeMax);
        query.setParameter("p_filterByCostRangeMin", filterByCostRangeMin);
        query.setParameter("p_filterByQuantityRangeMax", filterByQuantityRangeMax);
        query.setParameter("p_filterByQuantityRangeMin", filterByQuantityRangeMin);

        // Ejecutar procedimiento
        query.execute();

        // Obtener los resultados
        List<ProductInventoryDTO> products = query.getResultList();
        Integer totalRecords = (Integer) query.getOutputParameterValue("p_totalRecords");

        // Mapear respuesta
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("products", products);
        responseData.put("totalRecords", totalRecords);
        
        return responseData;
    }

    @Transactional
    public int addProductInventory(Long pIdUser, String code, String name, int quantity, Float cost, Long pLoggedIdUser){
        return productInventoryRepo.addProductInventory(pIdUser, code, name, quantity, cost, pLoggedIdUser);
    }

    @Transactional
    public int updateProductInventory(Long pIdProductInventory, Long pIdUser, String code, String name, int quantity, Float cost, Long pLoggedIdUser){
        return productInventoryRepo.updateProductInventory(pIdProductInventory, pIdUser, code, name, quantity, cost, pLoggedIdUser);
    }

    @Transactional
    public int deleteProductInventory(Long pIdProductInventory, Long pLoggedIdUser){
        return productInventoryRepo.deleteProductInventory(pIdProductInventory, pLoggedIdUser);
    }
    
}
