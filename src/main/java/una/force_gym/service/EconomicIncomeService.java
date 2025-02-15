package una.force_gym.service;

import java.time.LocalDate;
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
import una.force_gym.dto.EconomicIncomeDTO;
import una.force_gym.repository.EconomicIncomeRepository;

@Service
public class EconomicIncomeService {

    @Autowired
    private EconomicIncomeRepository economicIncomeRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> getEconomicIncomes(
        int page, 
        int size, int searchType, 
        String searchTerm, 
        String orderBy, 
        String directionOrderBy, 
        String filterByStatus,
        String filterByAmountRange,
        String filterByDateRange
    ) {
            
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("prGetEconomicIncome", EconomicIncomeDTO.class);
        
        // Parámetros de entrada
        query.registerStoredProcedureParameter("p_page", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_limit", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_searchType", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_searchTerm", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_orderBy", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_directionOrderBy", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByStatus", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByAmountRange", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByDateRange", String.class, ParameterMode.IN);

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
        query.setParameter("p_filterByAmountRange", filterByAmountRange);
        query.setParameter("p_filterByDateRange", filterByDateRange);

        // Ejecutar procedimiento
        query.execute();

        // Obtener los resultados
        List<EconomicIncomeDTO> products = query.getResultList();
        Integer totalRecords = (Integer) query.getOutputParameterValue("p_totalRecords");

        // Mapear respuesta
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("economicIncomes", products);
        responseData.put("totalRecords", totalRecords);
        
        return responseData;
    }

    public Long countActiveIncomes(){
        return economicIncomeRepo.countByIsDeleted(Long.valueOf(0));
    }

    @Transactional
    public int addEconomicIncome(Long pIdUser, LocalDate pRegistrationDate, String pVoucherNumber, String pDetail, Long pIdMeanOfPayment, Float pAmount, Long pIdActivityType, Long pLoggedIdUser){
        return economicIncomeRepo.addEconomicIncome(pIdUser, pRegistrationDate, pVoucherNumber, pDetail, pIdMeanOfPayment, pAmount, pIdActivityType, pLoggedIdUser);
    }

    @Transactional
    public int updateEconomicIncome(Long pIdEconomicIncome, Long pIdUser, LocalDate pRegistrationDate, String pVoucherNumber, String pDetail, Long pIdMeanOfPayment, Float pAmount, Long pIdActivityType, Long pLoggedIdUser){
        return economicIncomeRepo.updateEconomicIncome(pIdEconomicIncome, pIdUser, pRegistrationDate, pVoucherNumber, pDetail, pIdMeanOfPayment, pAmount, pIdActivityType, pLoggedIdUser);
    }

    @Transactional
    public int deleteEconomicIncome(Long pIdEconomicIncome, Long pLoggedIdUser){
        return economicIncomeRepo.deleteEconomicIncome(pIdEconomicIncome, pLoggedIdUser);
    }

}
