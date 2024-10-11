package una.force_gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import una.force_gym.service.UserService;
import una.force_gym.util.ApiResponse;
import una.force_gym.domain.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<User>>> getUsers() {
        try {
            List<User> users = userService.getUsers();
            ApiResponse<List<User>> response = new ApiResponse<>("Usuarios obtenidos correctamente.", users);
            return new ResponseEntity<>(response, HttpStatus.OK); 

        } catch (RuntimeException e) {
            ApiResponse<List<User>> response = new ApiResponse<>("Ocurrió un error al solicitar los datos de los usuarios.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }

    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addUser(@RequestBody User user) {

        try {
            int result = userService.addUser(user.getIdRole(), user.getIdPerson(), user.getUsername(), user.getPassword());
            ApiResponse<String> response;

            switch(result){
                case 1 -> 
                { 
                    response = new ApiResponse<>("Usuario agregado correctamente.", null);
                    return new ResponseEntity<>(response, HttpStatus.OK); 
                }

                case 0 -> // error de mysql
                {    
                    response = new ApiResponse<>("Ocurrió un error al agregar el nuevo usuario.", null);
                }
                
                case -1 -> // no se encuentra el idPerson
                {

                   response = new ApiResponse<>("No se pudo agregar el nuevo usuario debido a que la persona asociada no está registrada.", null);
                }

                case -2 -> // no se encuentra el idRole
                {   
                    response = new ApiResponse<>("No se pudo agregar el nuevo usuario debido a que el rol asociado no está registrado.", null);
                }

                case -3 -> // username duplicado
                {   
                    response = new ApiResponse<>("No se pudo agregar el nuevo usuario debido a que el nombre de usuario ya existe.", null);
                }

                default -> {
                    throw new RuntimeException("Usuario no agregado debido a problemas en la consulta.");
                }
            }

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (RuntimeException e) {
            ApiResponse<String> response = new ApiResponse<>("Ocurrió un error al agregar el nuevo usuario.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }

    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateUser(@RequestBody User user) {

        try {
            int result = userService.updateUser(user.getIdUser(), user.getIdRole(), user.getIdPerson(), user.getUsername(), user.getPassword());
            ApiResponse<String> response;

            switch(result){
                case 1 -> 
                {   response = new ApiResponse<>("Usuario actualizado correctamente.", null);
                    return new ResponseEntity<>(response, HttpStatus.OK); 
                }

                case 0 -> // error de mysql
                {   
                    response = new ApiResponse<>("Ocurrió un error al actualizar el usuario.", null);
                }

                case -1 -> // no se encuentra el idUser
                {   
                    response = new ApiResponse<>("No se pudo actualizar el usuario debido a que no se encuentra el registro.", null);
                }
                
                case -2 -> // no se encuentra el idPerson
                {    
                    response = new ApiResponse<>("No se pudo actualizar el usuario debido a que la persona asociada no está registrada.", null);
                }
                
                case -3 -> // no se encuentra el idRole
                {    
                    response = new ApiResponse<>("No se pudo actualizar el usuario debido a que el rol asociado no está registrado.", null);
                }

                case -4 -> // username duplicado
                {    
                    response = new ApiResponse<>("No se pudo actualizar el usuario debido a que el nombre de usuario ya existe.", null);
                }

                default -> {
                    throw new RuntimeException("Usuario no actualizado debido a problemas en la consulta.");
                }
            }
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (RuntimeException e) {
            ApiResponse<String> response = new ApiResponse<>("Ocurrió un error al actualizar el usuario.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }

    }

    @DeleteMapping("/delete/{idUser}")
    public ResponseEntity<ApiResponse<String>> deleteUser(@PathVariable("idUser") Long idUser) {

        try {  
            int result = userService.deleteUser(idUser);
            ApiResponse<String> response;

            switch(result){
                case 1 ->
                {
                    response = new ApiResponse<>("Usuario eliminado correctamente.", null);
                    return new ResponseEntity<>(response, HttpStatus.OK); 
                }
                
                case 0 -> // error de mysql
                { 
                    response = new ApiResponse<>("Ocurrió un error al eliminar el usuario.", null);
                }

                case -1 -> // no se encuentra el idUser
                {    
                    response = new ApiResponse<>("No se pudo eliminar el usuario debido a que no se encuentra el registro.", null);
                }

                default -> 
                {
                    throw new RuntimeException("Usuario no eliminado debido a problemas en la consulta.");
                }
            }

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (RuntimeException e) {
            ApiResponse<String> response = new ApiResponse<>("Ocurrió un error al eliminar el usuario.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }

    }
    
}
