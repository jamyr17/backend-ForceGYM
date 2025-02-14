package una.force_gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import una.force_gym.domain.HealthQuestionnaire;
import una.force_gym.repository.HealthQuestionnaireRepository;

@Service
public class HealthQuestionnaireService {

    @Autowired
    private HealthQuestionnaireRepository healthQuestionnaireRepo;

    public List<HealthQuestionnaire> getHealthQuestionnaires(int page, int size) {
        return healthQuestionnaireRepo.getHealthQuestionnaires(page, size);
    }

    public Long countActiveHealthQuestionnaires() {
        return healthQuestionnaireRepo.countByIsDeleted(0L);
    }

    @Transactional
    public int addHealthQuestionnaire(Long pIdClient, Boolean pDiabetes, Boolean pHypertension, 
                                      Boolean pMuscleInjuries, Boolean pBoneJointIssues, Boolean pBalanceLoss, 
                                      Boolean pCardiovascularDisease, Boolean pBreathingIssues, Long pLoggedIdUser) {
        return healthQuestionnaireRepo.addHealthQuestionnaire(pIdClient, pDiabetes, pHypertension, pMuscleInjuries, 
                                                              pBoneJointIssues, pBalanceLoss, pCardiovascularDisease, 
                                                              pBreathingIssues, pLoggedIdUser);
    }

    @Transactional
    public int updateHealthQuestionnaire(Long pIdHealthQuestionnaire, Boolean pDiabetes, Boolean pHypertension, 
                                         Boolean pMuscleInjuries, Boolean pBoneJointIssues, Boolean pBalanceLoss, 
                                         Boolean pCardiovascularDisease, Boolean pBreathingIssues, Long pLoggedIdUser) {
        return healthQuestionnaireRepo.updateHealthQuestionnaire(pIdHealthQuestionnaire, pDiabetes, pHypertension, 
                                                                 pMuscleInjuries, pBoneJointIssues, pBalanceLoss, 
                                                                 pCardiovascularDisease, pBreathingIssues, pLoggedIdUser);
    }

    @Transactional
    public int deleteHealthQuestionnaire(Long idHealthQuestionnaire, Long pLoggedIdUser){
        return healthQuestionnaireRepo.deleteHealthQuestionnaire(idHealthQuestionnaire, pLoggedIdUser);
    }
}
