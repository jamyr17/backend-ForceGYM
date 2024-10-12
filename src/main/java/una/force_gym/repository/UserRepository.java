package una.force_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    @Procedure(procedureName = "prGetUser")
    List<User> getUsers(); 

    @Procedure(procedureName = "prInsertUser", outputParameterName = "result")
    int addUser(@Param("pIdRole") Long pIdRole, @Param("pIdPerson") Long pIdPerson, @Param("pUsername") String pUsername, @Param("pPassword") String pPassword, @Param("pLoggedIdUser") Long pLoggedIdUser); 

    @Procedure(procedureName = "prUpdateUser", outputParameterName = "result")
    int updateUser(@Param("pIdUser") Long pIdUser, @Param("pIdRole") Long pIdRole, @Param("pIdPerson") Long pIdPerson, @Param("pUsername") String pUsername, @Param("pPassword") String pPassword, @Param("pLoggedIdUser") Long pLoggedIdUser); 

    @Procedure(procedureName = "prDeleteUser", outputParameterName = "result")
    int deleteUser(@Param("pIdUser") Long pIdUser, @Param("pLoggedIdUser") Long pLoggedIdUser); 
    
}
