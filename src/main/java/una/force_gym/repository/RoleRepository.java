package una.force_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import una.force_gym.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    
    @Procedure(procedureName = "prGetRole")
    List<Role> getRoles(); 

}
