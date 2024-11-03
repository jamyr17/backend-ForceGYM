package una.force_gym.mapper;

import org.springframework.stereotype.Component;

import una.force_gym.domain.User;
import una.force_gym.dto.LoginDTO;
import una.force_gym.dto.UserDTO;

@Component
public class UserMapper {

    public UserDTO toUserDTO(User user) {
        if (user == null) {
            return null;
        }

        return new UserDTO(
            user.getIdUser(),
            user.getPerson(),
            user.getRole(),
            user.getUsername()
        );
    }

    public LoginDTO toLoginDTO(User user) {
        if (user == null) {
            return null;
        }

        return new LoginDTO(
            user.getIdUser(),
            user.getPerson(),
            user.getRole(),
            user.getUsername(),
            ""  
        );
    }

}
