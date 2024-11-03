package una.force_gym.service;

import java.nio.CharBuffer;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import una.force_gym.domain.User;
import una.force_gym.dto.CredentialsDTO;
import una.force_gym.dto.LoginDTO;
import una.force_gym.dto.UserDTO;
import una.force_gym.exception.AppException;
import una.force_gym.mapper.UserMapper;
import una.force_gym.repository.UserDTORepository;
import una.force_gym.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired 
    private UserRepository userRepo;

    @Autowired 
    private UserDTORepository userDTORepo;

    @Autowired 
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;
    
    @Transactional
    public List<UserDTO> getUsers(){
        return userDTORepo.getUsers();
    }

    @Transactional
    public int addUser(Long pIdRole, String pName, String pFirstLastName, String pSecondLastName, LocalDate pBirthday, String pIdentificationNumber, String pPhoneNunber, String pEmail, String pGender, String pUsername, String pPassword, Long pLoggedIdUser){
        String encodedPassword = (pPassword != null) ? passwordEncoder.encode(pPassword) : null;
        return userRepo.addUser(pIdRole, pName, pFirstLastName, pSecondLastName, pBirthday, pIdentificationNumber, pPhoneNunber, pEmail, pGender, pUsername, encodedPassword, pLoggedIdUser);
    }

    @Transactional
    public int updateUser(Long pIdUser, Long pIdRole, Long pIdPerson, String pName, String pFirstLastName, String pSecondLastName, LocalDate pBirthday, String pIdentificationNumber, String pPhoneNumber, String pEmail, String pGender, String pUsername, String pPassword, Long pLoggedIdUser){
        String encodedPassword = (pPassword != null) ? passwordEncoder.encode(pPassword) : null;
        return userRepo.updateUser(pIdUser, pIdRole, pIdPerson, pName, pFirstLastName, pSecondLastName, pBirthday, pIdentificationNumber, pPhoneNumber, pEmail, pGender, pUsername, encodedPassword, pLoggedIdUser);
    }

    @Transactional
    public int deleteUser(Long pIdUser, Long pLoggedIdUser){
        return userRepo.deleteUser(pIdUser, pLoggedIdUser);
    }

    @Transactional
    public LoginDTO login(CredentialsDTO credentialsDTO) {
        User user = userRepo.findByUsername(credentialsDTO.getUsername())
                .orElseThrow(() -> new AppException("Usuario inválido", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDTO.getPassword()), user.getPassword())) {
            return userMapper.toLoginDTO(user);
        }
        throw new AppException("Credenciales inválidas", HttpStatus.BAD_REQUEST);
    }

    @Transactional
    public UserDTO findByUsername(String username) {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new AppException("Usuario inválido", HttpStatus.NOT_FOUND));
        return userMapper.toUserDTO(user);
    }

}
