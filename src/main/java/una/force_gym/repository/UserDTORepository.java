package una.force_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import una.force_gym.dto.UserDTO;

public interface UserDTORepository extends JpaRepository<UserDTO, Long>{
    
    @Procedure(procedureName = "prGetUser")
    List<UserDTO> getUsers(); 
    
}
