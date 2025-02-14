package una.force_gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import una.force_gym.domain.Permission;
import una.force_gym.repository.PermissionRepository;

@Service
public class PermissionService {
    
    @Autowired
    private PermissionRepository permissionRepo;

    public List<Permission> getPermissions(int page, int size) {
        return permissionRepo.getPermissions(page, size);
    }

    public Long countActivePermissions() {
        return permissionRepo.countByIsDeleted(0L);
    }

    @Transactional
    public int addPermission(   String pDefinition, 
    String pDescription,
    Long pLoggedIdUser) {
        return permissionRepo.addPermission(pDefinition, 
        pDescription, 
                                            pLoggedIdUser);
    }

    @Transactional
    public int updatePermission(Long pIdPermission, 
                                String pDefinition, 
                                String pDescription,
                                Long pLoggedIdUser) {
        return permissionRepo.updatePermission( pIdPermission,
                                                pDefinition, 
                                                pDescription, 
                                                pLoggedIdUser);
    }

    @Transactional
    public int deletePermission(Long idPermission, Long pLoggedIdUser){
        return permissionRepo.deletePermission(idPermission, pLoggedIdUser);
    }
}