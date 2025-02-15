package una.force_gym.service;

import java.util.Date;
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
import una.force_gym.dto.MeasurementDTO;
import una.force_gym.repository.MeasurementRepository;

@Service
public class MeasurementService {
    
    @Autowired
    private MeasurementRepository measurementRepository;


    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> getMeasurements(
        int page, 
        int size, int searchType, 
        String searchTerm, 
        String orderBy, 
        String directionOrderBy, 
        String filterByStatus
    ) {
            
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("prGetMeasurement", MeasurementDTO.class);
        
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
        List<MeasurementDTO> products = query.getResultList();
        Integer totalRecords = (Integer) query.getOutputParameterValue("p_totalRecords");

        // Mapear respuesta
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("measurements", products);
        responseData.put("totalRecords", totalRecords);
        
        return responseData;
    }
    @Transactional
    public int addMeasurement(Long pIdClient, 
                                        Date pMeasurementDate, 
                                        Float pWeight, 
                                        Float pHeight, 
                                        Float pMuscleMass, 
                                        Float pBodyFatPercentage, 
                                        Float pVisceralFatPercentage, 
                                        Float pNeckSize, 
                                        Float pShoulderSize, 
                                        Float pChestSize, 
                                        Float pwaistSize,
                                        Float pThighSize, 
                                        Float pCalfSize, 
                                        Float pForearmSize, 
                                        Float pArmSize, 
                                        Long pLoggedIdUser) {
        return measurementRepository.addMeasurement(pIdClient, 
                                                    pMeasurementDate, 
                                                    pWeight,
                                                    pHeight, 
                                                    pMuscleMass, 
                                                    pBodyFatPercentage, 
                                                    pVisceralFatPercentage, 
                                                    pNeckSize, 
                                                    pShoulderSize, 
                                                    pChestSize,
                                                    pwaistSize, 
                                                    pThighSize, 
                                                    pCalfSize, 
                                                    pForearmSize, 
                                                    pArmSize,  
                                                    pLoggedIdUser);
    }

    @Transactional
    public int updateMeasurement(Long pIdMeasurement, 
                                            Long pIdClient, 
                                            Date pMeasurementDate, 
                                            Float pWeight, 
                                            Float pHeight, 
                                            Float pMuscleMass, 
                                            Float pBodyFatPercentage, 
                                            Float pVisceralFatPercentage, 
                                            Float pNeckSize, 
                                            Float pShoulderSize, 
                                            Float pChestSize, 
                                            Float pwaistSize,
                                            Float pThighSize, 
                                            Float pCalfSize, 
                                            Float pForearmSize, 
                                            Float pArmSize, 
                                            Long pLoggedIdUser) {
        return measurementRepository.updateMeasurement(pIdMeasurement, 
                                                        pIdClient,
                                                        pMeasurementDate, 
                                                        pWeight,
                                                        pHeight, 
                                                        pMuscleMass, 
                                                        pBodyFatPercentage, 
                                                        pVisceralFatPercentage, 
                                                        pNeckSize, 
                                                        pShoulderSize, 
                                                        pChestSize,
                                                        pwaistSize, 
                                                        pThighSize, 
                                                        pCalfSize, 
                                                        pForearmSize, 
                                                        pArmSize,  
                                                        pLoggedIdUser);
    }

    @Transactional
    public int deleteMeasurement(Long idMeasurement, Long pLoggedIdUser){
        return measurementRepository.deleteMeasurement(idMeasurement, pLoggedIdUser);
    }
}
