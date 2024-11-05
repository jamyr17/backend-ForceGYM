package una.force_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.dto.UserDTO;

import org.springframework.data.jpa.repository.Query;

public interface UserDTORepository extends JpaRepository<UserDTO, Long>{
    
    @Procedure(procedureName = "prGetUser")
    List<UserDTO> getUsers(@Param("p_page") int p_page, @Param("p_limit") int p_limit); 
    
    Long countByIsDeleted(Long isDeleted);

    @Procedure(procedureName = "prGetUserByRole")
    List<UserDTO> getUsersByRole(@Param("pIdRole") int pIdRole, @Param("p_page") int p_page, @Param("p_limit") int p_limit);

    @Query("SELECT COUNT(u) FROM UserDTO u WHERE u.role = :role AND u.isDeleted = 0")
    Long countUsersByRole(@Param("role") int role);


}