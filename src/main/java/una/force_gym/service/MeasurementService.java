package una.force_gym.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import una.force_gym.domain.Measurement;
import una.force_gym.repository.MeasurementRepository;

@Service
public class MeasurementService {
    
    @Autowired
    private MeasurementRepository measurementRepository;

    public List<Measurement> getMeasurements(int page, int size) {
        return measurementRepository.getMeasurements(page, size);
    }

    public Long countActiveMeasurements() {
        return measurementRepository.countByIsDeleted(0L);
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
