package una.force_gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import una.force_gym.domain.Role;
import una.force_gym.service.RoleService;
import una.force_gym.util.ApiResponse;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<Role>>> getRoles() {
        try {
            List<Role> roles = roleService.getRoles();
            ApiResponse<List<Role>> response = new ApiResponse<>("Roles obtenidos correctamente.", roles);
            return new ResponseEntity<>(response, HttpStatus.OK); 

        } catch (RuntimeException e) {
            ApiResponse<List<Role>> response = new ApiResponse<>("Ocurrió un error al solicitar los datos de los roles.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }

    }
    
}
