package una.force_gym.service;

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
    public List<EconomicExpense> getEconomicExpenses(){
        return economicExpenseRepo.getEconomicExpenses();
    }

    // servicio de add

    // servicio de update

    @Transactional
    public int deleteEconomicExpense(Long pIdEconomicExpense, Long pLoggedIdUser){
        return economicExpenseRepo.deleteEconomicExpense(pIdEconomicExpense, pLoggedIdUser);
    }
    
}
