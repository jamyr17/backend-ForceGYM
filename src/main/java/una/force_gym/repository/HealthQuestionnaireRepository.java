package una.force_gym.repository;

import una.force_gym.domain.HealthQuestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface HealthQuestionnaireRepository extends JpaRepository<HealthQuestionnaire, Long> {

    @Procedure(procedureName = "prInsertHealthQuestionnaire", outputParameterName = "result")
    int addHealthQuestionnaire(
        @Param("pIdClient") Long pIdClient,
        @Param("pDiabetes") Boolean pDiabetes,
        @Param("pHypertension") Boolean pHypertension,
        @Param("pMuscleInjuries") Boolean pMuscleInjuries,
        @Param("pBoneJointIssues") Boolean pBoneJointIssues,
        @Param("pBalanceLoss") Boolean pBalanceLoss,
        @Param("pCardiovascularDisease") Boolean pCardiovascularDisease,
        @Param("pBreathingIssues") Boolean pBreathingIssues,
        @Param("pLoggedIdUser") Long pLoggedIdUser
    );

    @Procedure(procedureName = "prUpdateHealthQuestionnaire", outputParameterName = "result")
    int updateHealthQuestionnaire(
        @Param("pIdHealthQuestionnaire") Long pIdHealthQuestionnaire,
        @Param("pDiabetes") Boolean pDiabetes,
        @Param("pHypertension") Boolean pHypertension,
        @Param("pMuscleInjuries") Boolean pMuscleInjuries,
        @Param("pBoneJointIssues") Boolean pBoneJointIssues,
        @Param("pBalanceLoss") Boolean pBalanceLoss,
        @Param("pCardiovascularDisease") Boolean pCardiovascularDisease,
        @Param("pBreathingIssues") Boolean pBreathingIssues,
        @Param("pLoggedIdUser") Long pLoggedIdUser
    );

    @Procedure(procedureName = "prDeleteHealthQuestionnaire", outputParameterName = "result")
    int deleteHealthQuestionnaire(  @Param("pIdHealthQuestionnaire") Long pIdHealthQuestionnaire, 
                                    @Param("pLoggedIdUser") Long pLoggedIdUser);
}
