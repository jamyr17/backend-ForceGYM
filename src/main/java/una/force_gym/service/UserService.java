package una.force_gym.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import una.force_gym.domain.User;
import una.force_gym.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired 
    private UserRepository userRepo;
    
    @Transactional
    public List<User> getUsers(){
        int result = 0;
        return userRepo.getUsers(result);
    }

    @Transactional
    public int addUser(Long pIdRole, Long pIdPerson, String pUsername, String pPassword){
        return userRepo.addUser(pIdRole, pIdPerson, pUsername, pPassword);
    }

    @Transactional
    public int updateUser(Long pIdUser, Long pIdRole, Long pIdPerson, String pUsername, String pPassword){
        return userRepo.updateUser(pIdUser, pIdRole, pIdPerson, pUsername, pPassword);
    }

    @Transactional
    public int deleteUser(Long pIdUser){
        return userRepo.deleteUser(pIdUser);
    }

}
