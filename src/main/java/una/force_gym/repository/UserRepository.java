package una.force_gym.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

    @Procedure(procedureName = "prInsertUser", outputParameterName = "result")
    int addUser(@Param("pIdRole") Long pIdRole, @Param("pName") String pName, @Param("pFirstLastNameame") String pFirstLastName, @Param("pSecondLastName") String pSecondLastName, @Param("pBirthday") LocalDate pBirthday, @Param("pIdentificationNumber") String pIdentificationNumber, @Param("pPhoneNumber") String pPhoneNumber, @Param("pEmail") String pEmail, @Param("pGender") String pGender, @Param("pUsername") String pUsername, @Param("pPassword") String pPassword, @Param("pLoggedIdUser") Long pLoggedIdUser); 

    @Procedure(procedureName = "prUpdateUser", outputParameterName = "result")
    int updateUser(@Param("pIdUser") Long pIdUser, @Param("pIdRole") Long pIdRole, @Param("pIdPerson") Long pIdPerson, @Param("pName") String pName, @Param("pFirstLastNameame") String pFirstLastName, @Param("pSecondLastName") String pSecondLastName, @Param("pBirthday") LocalDate pBirthday, @Param("pIdentificationNumber") String pIdentificationNumber, @Param("pPhoneNumber") String pPhoneNumber, @Param("pEmail") String pEmail, @Param("pGender") String pGender, @Param("pUsername") String pUsername, @Param("pPassword") String pPassword, @Param("pLoggedIdUser") Long pLoggedIdUser); 

    @Procedure(procedureName = "prDeleteUser", outputParameterName = "result")
    int deleteUser(@Param("pIdUser") Long pIdUser, @Param("pLoggedIdUser") Long pLoggedIdUser); 

    Optional<User> findByUsernameAndIsDeleted(String username, Long isDeleted);
    
    @Query(value = "SELECT * FROM tbUser p WHERE p.isDeleted = 0 AND " +
               "LOWER(p.username) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
               "LIMIT :size OFFSET :offset", nativeQuery = true)
    List<User> searchUsers(@Param("searchTerm") String searchTerm, @Param("offset") int offset, @Param("size") int size);

    @Query(value = "SELECT COUNT(*) FROM tbUser p WHERE p.isDeleted = 0 AND " +
                "LOWER(p.username) LIKE LOWER(CONCAT('%', :searchTerm, '%'))", nativeQuery = true)
    Long countBySearchTerm(@Param("searchTerm") String searchTerm);


}
