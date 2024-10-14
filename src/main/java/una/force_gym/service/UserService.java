package una.force_gym.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import una.force_gym.dto.UserDTO;
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

}
