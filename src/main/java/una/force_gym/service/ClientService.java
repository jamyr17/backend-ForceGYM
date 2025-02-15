package una.force_gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import una.force_gym.domain.Client;
import una.force_gym.repository.ClientRepository;

import java.util.Date;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepo;

    @Transactional
    public List<Client> getClients(int page, int size) {
        return clientRepo.getClients(page, size);
    }

    public Long countActiveClients() {
        return clientRepo.countByIsDeleted(Long.valueOf(0));
    }

    @Transactional
    public int addClient(Long idPerson, Long idTypeClient, Long idHealthQuestionnaire, Long idUser,
                         Date registrationDate, String emergencyContact, String signatureImage, Long pLoggedIdUser) {
        return clientRepo.addClient(idPerson, idTypeClient, idHealthQuestionnaire, idUser, 
                         registrationDate, emergencyContact, signatureImage, pLoggedIdUser);
    }

    @Transactional
    public int updateClient(Long idClient, Long idPerson, Long idTypeClient, Long idHealthQuestionnaire, Long idUser,
                         Date registrationDate, String emergencyContact, String signatureImage, Long pLoggedIdUser) {
        return clientRepo.updateClient(idClient, idPerson, idTypeClient, idHealthQuestionnaire, idUser, registrationDate, emergencyContact, signatureImage, pLoggedIdUser);
    }

    @Transactional
    public int deleteClient(Long idClient, Long pLoggedIdUser) {
        return clientRepo.deleteClient(idClient, pLoggedIdUser);
    }
}
