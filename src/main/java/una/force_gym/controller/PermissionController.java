package una.force_gym.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import una.force_gym.domain.Permission;
import una.force_gym.dto.ParamLoggedIdUserDTO;
import una.force_gym.dto.PermissionDTO;
import una.force_gym.exception.AppException;
import una.force_gym.service.PermissionService;
import una.force_gym.util.ApiResponse;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getPermissions( 
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "1") int searchType,
            @RequestParam(defaultValue = "") String searchTerm,
            @RequestParam(defaultValue = "") String orderBy,
            @RequestParam(defaultValue = "") String directionOrderBy,
            @RequestParam(defaultValue = "") String filterByStatus
            )  {
        try {
            Map<String, Object> responseData = permissionService.getPermissions(page, size, searchType, searchTerm, orderBy, directionOrderBy, filterByStatus);
            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Permisos obtenidos correctamente.", responseData);
            return new ResponseEntity<>(response, HttpStatus.OK); 

        } catch (RuntimeException e) {
            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Ocurrió un error al solicitar los datos de los permisos.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }

    }
    
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addPermission(@RequestBody PermissionDTO permissionDTO) {
        int result = permissionService.addPermission(
            permissionDTO.getDefinition(),
            permissionDTO.getDescription(),
            permissionDTO.getParamLoggedIdUser()
        );

        switch(result) {
            case 1 -> { 
                ApiResponse<String> response = new ApiResponse<>("Permiso agregado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            case 0 -> throw new AppException("Ocurrió un error al agregar el nuevo permiso.", HttpStatus.INTERNAL_SERVER_ERROR);
            default -> throw new AppException("Permiso no agregado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updatePermission(@RequestBody PermissionDTO permissionDTO) {
        int result = permissionService.updatePermission(
            permissionDTO.getIdPermission(),
            permissionDTO.getDefinition(),
            permissionDTO.getDescription(),
            permissionDTO.getParamLoggedIdUser()
        );

        switch(result) {
            case 1 -> { 
                ApiResponse<String> response = new ApiResponse<>("Permiso actualizado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            case 0 -> throw new AppException("Ocurrió un error al actualizar el permiso.", HttpStatus.INTERNAL_SERVER_ERROR);
            case -1 -> throw new AppException("No se pudo actualizar el permiso porque no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);
            default -> throw new AppException("Permiso no actualizado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{idPermission}")
    public ResponseEntity<ApiResponse<String>> deletePermission(@PathVariable("idPermission") Long idPermission, @RequestBody ParamLoggedIdUserDTO paramLoggedIdUser) {
        int result = permissionService.deletePermission(idPermission, paramLoggedIdUser.getParamLoggedIdUser());

        switch(result) {
            case 1 -> { 
                ApiResponse<String> response = new ApiResponse<>("Permiso eliminado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            case 0 -> throw new AppException("Ocurrió un error al eliminar el permiso.", HttpStatus.INTERNAL_SERVER_ERROR);
            case -1 -> throw new AppException("No se pudo eliminar el permiso porque no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);
            default -> throw new AppException("Permiso no eliminado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}