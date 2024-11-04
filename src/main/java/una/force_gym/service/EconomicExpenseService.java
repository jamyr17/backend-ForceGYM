package una.force_gym.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import una.force_gym.domain.EconomicExpense;
import una.force_gym.repository.EconomicExpenseRepository;

@Service
public class EconomicExpenseService {

    @Autowired
    private EconomicExpenseRepository economicExpenseRepo;

    @Transactional
    public List<EconomicExpense> getEconomicExpenses(int page, int size) {
        return economicExpenseRepo.getEconomicExpenses(page, size);
    }

    public Long countActiveExpenses(){
        return economicExpenseRepo.countByIsDeleted(Long.valueOf(0));
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

    @Transactional
    public List<EconomicExpense> getEconomicExpensesByAmountRange(double minAmount, double maxAmount, int page, int size) {
        return economicIncomeRepo.getEconomicExpensesByAmountRange(minAmount, maxAmount, page, size);
    }

    @Transactional
    public List<EconomicExpense> getEconomicExpensesByDateRange(LocalDate startDate, LocalDate endDate, int page, int size) {
        return economicIncomeRepo.getEconomicExpensesByDateRange(startDate, endDate, page, size);
    }
    
}
