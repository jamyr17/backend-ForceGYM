package una.force_gym.service;

import java.nio.CharBuffer;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

import una.force_gym.domain.User;
import una.force_gym.dto.CredentialsDTO;
import una.force_gym.dto.LoginDTO;
import una.force_gym.dto.UserDTO;
import una.force_gym.exception.AppException;
import una.force_gym.mapper.UserMapper;
import una.force_gym.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired 
    private UserRepository userRepo;

    @Autowired 
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;
    
    @PersistenceContext
    private EntityManager entityManager;

    public Map<String, Object> getUsers(
        int page, 
        int size, int searchType, 
        String searchTerm, 
        String orderBy, 
        String directionOrderBy, 
        String filterByStatus, 
        String filterByRole
    ) {
            
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("prGetUser", UserDTO.class);
        
        // Parámetros de entrada
        query.registerStoredProcedureParameter("p_page", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_limit", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_searchType", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_searchTerm", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_orderBy", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_directionOrderBy", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByStatus", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_filterByRole", String.class, ParameterMode.IN);

        // Parámetro de salida
        query.registerStoredProcedureParameter("p_totalRecords", Integer.class, ParameterMode.OUT);

        // Setear valores
        query.setParameter("p_page", page);
        query.setParameter("p_limit", size);
        query.setParameter("p_searchType", searchType);
        query.setParameter("p_searchTerm", searchTerm);
        query.setParameter("p_orderBy", orderBy);
        query.setParameter("p_directionOrderBy", directionOrderBy);
        query.setParameter("p_filterByStatus", filterByStatus);
        query.setParameter("p_filterByRole", filterByRole);

        // Ejecutar procedimiento
        query.execute();

        // Obtener los resultados
        List<UserDTO> users = query.getResultList();
        Integer totalRecords = (Integer) query.getOutputParameterValue("p_totalRecords");

        // Mapear respuesta
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("users", users);
        responseData.put("totalRecords", totalRecords);
        
        return responseData;
    }

    @Transactional
    public int addUser(Long pIdRole, String pName, String pFirstLastName, String pSecondLastName, LocalDate pBirthday, String pIdentificationNumber, String pPhoneNumber, String pEmail, String pGender, String pUsername, String pPassword, Long pLoggedIdUser){
        String encodedPassword = (pPassword != null) ? passwordEncoder.encode(pPassword) : null;
        return userRepo.addUser(pIdRole, pName, pFirstLastName, pSecondLastName, pBirthday, pIdentificationNumber, pPhoneNumber, pEmail, pGender, pUsername, encodedPassword, pLoggedIdUser);
    }

    @Transactional
    public int updateUser(Long pIdUser, Long pIdRole, Long pIdPerson, String pName, String pFirstLastName, String pSecondLastName, LocalDate pBirthday, String pIdentificationNumber, String pPhoneNumber, String pEmail, String pGender, String pUsername, String pPassword, Long pIsDeleted, Long pLoggedIdUser){
        String encodedPassword = (pPassword != null) ? passwordEncoder.encode(pPassword) : null;
        return userRepo.updateUser(pIdUser, pIdRole, pIdPerson, pName, pFirstLastName, pSecondLastName, pBirthday, pIdentificationNumber, pPhoneNumber, pEmail, pGender, pUsername, encodedPassword, pIsDeleted, pLoggedIdUser);
    }

    @Transactional
    public int deleteUser(Long pIdUser, Long pLoggedIdUser){
        return userRepo.deleteUser(pIdUser, pLoggedIdUser);
    }

    @Transactional
    public LoginDTO login(CredentialsDTO credentialsDTO) {
        User user = userRepo.findByUsernameAndIsDeleted(credentialsDTO.getUsername(), Long.valueOf(0))
                .orElseThrow(() -> new AppException("Usuario inválido", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDTO.getPassword()), user.getPassword())) {
            return userMapper.toLoginDTO(user);
        }
        throw new AppException("Credenciales inválidas", HttpStatus.BAD_REQUEST);
    }

    @Transactional
    public UserDTO findByUsername(String username) {
        User user = userRepo.findByUsernameAndIsDeleted(username, Long.valueOf(0))
                .orElseThrow(() -> new AppException("Usuario inválido", HttpStatus.NOT_FOUND));
        return userMapper.toUserDTO(user);
    }

}
