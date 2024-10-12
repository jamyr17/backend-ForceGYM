package una.force_gym.service;

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

    // servicio de add

    // servicio de update

    @Transactional
    public int deleteEconomicIncome(Long pIdEconomicIncome, Long pLoggedIdUser){
        return economicIncomeRepo.deleteEconomicIncome(pIdEconomicIncome, pLoggedIdUser);
    }
    
}
