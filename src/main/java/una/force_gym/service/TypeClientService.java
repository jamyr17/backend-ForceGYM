package una.force_gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import una.force_gym.domain.TypeClient;
import una.force_gym.repository.TypeClientRepository;

@Service
public class TypeClientService {

    @Autowired
    private TypeClientRepository typeClientRepo;

    @Transactional
    public List<TypeClient> getTypeClients(int page, int size) {
        return typeClientRepo.getTypeClients(page, size);
    }

    public Long countActiveTypeClients() {
        return typeClientRepo.countByIsDeleted(Long.valueOf(0));
    }

    @Transactional
    public int addTypeClient(String name, Float dailyCharge, Float weeklyCharge, Float biweeklyCharge, Float monthlyCharge, Long pLoggedIdUser) {
        return typeClientRepo.addTypeClient(name, dailyCharge, weeklyCharge, biweeklyCharge, monthlyCharge, pLoggedIdUser);
    }

    @Transactional
    public int updateTypeClient(Long idTypeClient, String name, Float dailyCharge, Float weeklyCharge, Float biweeklyCharge, Float monthlyCharge, Long pLoggedIdUser) {
        return typeClientRepo.updateTypeClient(idTypeClient, name, dailyCharge, weeklyCharge, biweeklyCharge, monthlyCharge, pLoggedIdUser);
    }

    @Transactional
    public int deleteTypeClient(Long idTypeClient, Long pLoggedIdUser) {
        return typeClientRepo.deleteTypeClient(idTypeClient, pLoggedIdUser);
    }
}