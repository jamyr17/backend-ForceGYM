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
import una.force_gym.dto.EconomicExpenseDTO;
import una.force_gym.repository.EconomicExpenseRepository;

@Service
public class EconomicExpenseService {

    @Autowired
    private EconomicExpenseRepository economicExpenseRepo;

    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> getEconomicExpenses(
        int page, 
        int size, int searchType, 
        String searchTerm, 
        String orderBy, 
        String directionOrderBy, 
        String filterByStatus,
        String filterByAmountRangeMax,
        String filterByAmountRangeMin,
        String filterByDateRangeStart,
        String filterByDateRangeEnd
    ) {
            
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("prGetEconomicExpense", EconomicExpenseDTO.class);
        
        // Parámetros de entrada
        query.registerStoredProcedureParameter("p_page", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_limit", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_searchType", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_searchTerm", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_orderBy", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_directionOrderBy", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByStatus", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByAmountRangeMax", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByAmountRangeMin", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByDateRangeStart", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByDateRangeEnd", String.class, ParameterMode.IN);

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
        query.setParameter("p_filterByAmountRangeMax", filterByAmountRangeMax);
        query.setParameter("p_filterByAmountRangeMin", filterByAmountRangeMin);
        query.setParameter("p_filterByDateRangeStart", filterByDateRangeStart);
        query.setParameter("p_filterByDateRangeEnd", filterByDateRangeEnd);


        // Ejecutar procedimiento
        query.execute();

        // Obtener los resultados
        List<EconomicExpenseDTO> products = query.getResultList();
        Integer totalRecords = (Integer) query.getOutputParameterValue("p_totalRecords");

        // Mapear respuesta
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("economicExpenses", products);
        responseData.put("totalRecords", totalRecords);
        
        return responseData;
    }

    @Transactional
    public int addEconomicExpense(Long pIdUser, LocalDate pRegistrationDate, String pVoucherNumber, String pDetail, Long pIdMeanOfPayment, Float pAmount, Long pLoggedIdUser){
        return economicExpenseRepo.addEconomicExpense(pIdUser, pRegistrationDate, pVoucherNumber, pDetail, pIdMeanOfPayment, pAmount, pLoggedIdUser);
    }

    @Transactional
    public int updateEconomicExpense(Long pIdEconomicExpense, Long pIdUser, LocalDate pRegistrationDate, String pVoucherNumber, String pDetail, Long pIdMeanOfPayment, Float pAmount, Long pLoggedIdUser){
        return economicExpenseRepo.updateEconomicExpense(pIdEconomicExpense, pIdUser, pRegistrationDate, pVoucherNumber, pDetail, pIdMeanOfPayment, pAmount, pLoggedIdUser);
    }

    @Transactional
    public int deleteEconomicExpense(Long pIdEconomicExpense, Long pLoggedIdUser){
        return economicExpenseRepo.deleteEconomicExpense(pIdEconomicExpense, pLoggedIdUser);
    }

}
