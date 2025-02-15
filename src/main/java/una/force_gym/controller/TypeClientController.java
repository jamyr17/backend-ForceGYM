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

import una.force_gym.domain.TypeClient;
import una.force_gym.dto.ParamLoggedIdUserDTO;
import una.force_gym.dto.TypeClientDTO;
import una.force_gym.exception.AppException;
import una.force_gym.util.ApiResponse;
import una.force_gym.service.TypeClientService;

@RestController
@RequestMapping("/typeClient")
public class TypeClientController {
    
    @Autowired
    private TypeClientService typeClientService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getTypeClients(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size) {
        try {
            List<TypeClient> typeClients = typeClientService.getTypeClients(page, size);
            Long totalRecords = typeClientService.countActiveTypeClients();

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("typeClients", typeClients);
            responseData.put("totalRecords", totalRecords);

            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Tipos de cliente obtenidos correctamente.", responseData);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (RuntimeException e) {
            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Ocurrió un error al solicitar los datos de los tipos cliente.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addTypeClient(@RequestBody TypeClientDTO typeClientDTO) {
        int result = typeClientService.addTypeClient(
            typeClientDTO.getName(),
            typeClientDTO.getDailyCharge(),
            typeClientDTO.getWeeklyCharge(),
            typeClientDTO.getBiweeklyCharge(),
            typeClientDTO.getMonthlyCharge(),
            typeClientDTO.getParamLoggedIdUser()
        );

        switch(result) {
            case 1 -> { 
                ApiResponse<String> response = new ApiResponse<>("Tipo cliente agregado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            case 0 -> throw new AppException("Ocurrió un error al agregar el nuevo tipo cliente.", HttpStatus.INTERNAL_SERVER_ERROR);
            default -> throw new AppException("Tipo cliente no agregado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateTypeClient(@RequestBody TypeClientDTO typeClientDTO) {
        int result = typeClientService.updateTypeClient(
            typeClientDTO.getIdTypeClient(),
            typeClientDTO.getName(),
            typeClientDTO.getDailyCharge(),
            typeClientDTO.getWeeklyCharge(),
            typeClientDTO.getBiweeklyCharge(),
            typeClientDTO.getMonthlyCharge(),
            typeClientDTO.getParamLoggedIdUser()
        );

        switch(result) {
            case 1 -> { 
                ApiResponse<String> response = new ApiResponse<>("Tipo cliente actualizado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            case 0 -> throw new AppException("Ocurrió un error al actualizar el tipo cliente.", HttpStatus.INTERNAL_SERVER_ERROR);
            case -1 -> throw new AppException("No se pudo actualizar el tipo cliente porque no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);
            default -> throw new AppException("Tipo cliente no actualizado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{idTypeClient}")
    public ResponseEntity<ApiResponse<String>> deleteTypeClient(@PathVariable("idTypeClient") Long idTypeClient, @RequestBody ParamLoggedIdUserDTO paramLoggedIdUser) {
        int result = typeClientService.deleteTypeClient(idTypeClient, paramLoggedIdUser.getParamLoggedIdUser());

        switch(result) {
            case 1 -> { 
                ApiResponse<String> response = new ApiResponse<>("Tipo cliente eliminado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            case 0 -> throw new AppException("Ocurrió un error al eliminar el tipo cliente.", HttpStatus.INTERNAL_SERVER_ERROR);
            case -1 -> throw new AppException("No se pudo eliminar el tipo cliente porque no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);
            default -> throw new AppException("Tipo cliente no eliminado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}