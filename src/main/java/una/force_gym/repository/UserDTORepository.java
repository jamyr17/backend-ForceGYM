package una.force_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.dto.UserDTO;

public interface UserDTORepository extends JpaRepository<UserDTO, Long>{
    
    @Procedure(procedureName = "prGetUser")
    List<UserDTO> getUsers(
        @Param("p_page") int p_page, 
        @Param("p_limit") int p_limit, 
        @Param("p_searchType") int searchType, 
        @Param("p_searchTerm") String searchTerm,
        @Param("p_orderBy") String orderBy,
        @Param("p_directionOrderBy") String directionOrderBy,
        @Param("p_filterByStatus") String filterByStatus,
        @Param("p_filterByRole") String filterByRole
    ); 
    
    Long countByIsDeleted(Long isDeleted);

}
