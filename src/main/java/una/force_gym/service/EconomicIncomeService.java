package una.force_gym.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import una.force_gym.domain.EconomicIncome;
import una.force_gym.repository.EconomicIncomeRepository;

@Service
public class EconomicIncomeService {

    @Autowired
    private EconomicIncomeRepository economicIncomeRepo;

    @Transactional
    public List<EconomicIncome> getEconomicIncomes(){
        return economicIncomeRepo.getEconomicIncomes();
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
