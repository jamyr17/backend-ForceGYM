package una.force_gym.repository;

import una.force_gym.domain.Measurement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
   
    @Procedure(procedureName = "prInsertMeasurement", outputParameterName = "result")
    int addMeasurement(
        @Param("pIdClient") Long pidClient,
        @Param("pMeasurementDate") Date pMeasurementDate,
        @Param("pWeight") Float pWeight,
        @Param("pHeight") Float pHeight,
        @Param("pMuscleMass") Float pMuscleMass,
        @Param("pBodyFatPercentage") Float pBodyFatPercentage,
        @Param("pVisceralFatPercentage") Float pVisceralFatPercentage,
        @Param("pNeckSize") Float pNeckSize,
        @Param("pShoulderSize") Float pShoulderSize,
        @Param("pChestSize") Float pChestSize,
        @Param("pWaistSize") Float pWaistSize,
        @Param("pThighSize") Float pThighSize,
        @Param("pCalfSize") Float pCalfSize,
        @Param("pForearmSize") Float pForearmSize,
        @Param("pArmSize") Float pArmSize,
        @Param("pParamLoggedIdUser") Long pParamLoggedIdUser
    );

    @Procedure(procedureName = "prUpdateMeasurement", outputParameterName = "result")
    int updateMeasurement(
        @Param("pIdMeasurement") Long pIdMeasurement,
        @Param("pIdClient") Long pidClient,
        @Param("pMeasurementDate") Date pMeasurementDate,
        @Param("pWeight") Float pWeight,
        @Param("pHeight") Float pHeight,
        @Param("pMuscleMass") Float pMuscleMass,
        @Param("pBodyFatPercentage") Float pBodyFatPercentage,
        @Param("pVisceralFatPercentage") Float pVisceralFatPercentage,
        @Param("pNeckSize") Float pNeckSize,
        @Param("pShoulderSize") Float pShoulderSize,
        @Param("pChestSize") Float pChestSize,
        @Param("pWaistSize") Float pWaistSize,
        @Param("pThighSize") Float pThighSize,
        @Param("pCalfSize") Float pCalfSize,
        @Param("pForearmSize") Float pForearmSize,
        @Param("pArmSize") Float pArmSize,
        @Param("pParamLoggedIdUser") Long pParamLoggedIdUser
    );

    @Procedure(procedureName = "prDeleteMeasurement", outputParameterName = "result")
    int deleteMeasurement(@Param("pIdMeasurement") Long pIdMeasurement, @Param("pLoggedIdUser") Long pLoggedIdUser);
}