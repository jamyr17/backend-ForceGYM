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
    public List<EconomicIncome> getEconomicIncomes(int page, int size){
        return economicIncomeRepo.getEconomicIncomes(page, size);
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

    @Transactional
    public List<EconomicIncome> getEconomicIncomesByAmountRange(double minAmount, double maxAmount, int page, int size) {
        return economicIncomeRepo.getEconomicIncomesByAmountRange(minAmount, maxAmount, page, size);
    }

    @Transactional
    public List<EconomicIncome> getEconomicIncomesByDateRange(LocalDate startDate, LocalDate endDate, int page, int size) {
        return economicIncomeRepo.getEconomicIncomesByDateRange(startDate, endDate, page, size);
    }

}
