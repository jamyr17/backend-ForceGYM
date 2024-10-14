package una.force_gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import una.force_gym.domain.Role;
import una.force_gym.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired 
    private RoleRepository roleRepo;
    
    @Transactional
    public List<Role> getRoles(){
        return roleRepo.getRoles();
    }

}
