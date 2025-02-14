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

import una.force_gym.domain.Client;
import una.force_gym.dto.ClientDTO;
import una.force_gym.dto.ParamLoggedIdUserDTO;
import una.force_gym.exception.AppException;
import una.force_gym.service.ClientService;
import una.force_gym.util.ApiResponse;

@RestController
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    private ClientService clientService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getClients(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size) {
        try {
            List<Client> clients = clientService.getClients(page, size);
            Long totalRecords = clientService.countActiveClients();

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("clients", clients);
            responseData.put("totalRecords", totalRecords);

            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Clientes obtenidos correctamente.", responseData);
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (RuntimeException e) {
            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Ocurrió un error al solicitar los datos de los clientes.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addClient(@RequestBody ClientDTO clientDTO) {
        int result = clientService.addClient(
            clientDTO.getIdPerson(),
            clientDTO.getIdTypeClient(),
            clientDTO.getIdHealthQuestionnaire(),
            clientDTO.getIdUser(),
            clientDTO.getRegistrationDate(),
            clientDTO.getEmergencyContact(),
            clientDTO.getSignatureImage(),
            clientDTO.getParamLoggedIdUser()
        );

        switch(result) {
            case 1 -> { 
                ApiResponse<String> response = new ApiResponse<>("Cliente agregado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            case 0 -> throw new AppException("Ocurrió un error al agregar el nuevo cliente.", HttpStatus.INTERNAL_SERVER_ERROR);
            default -> throw new AppException("Cliente no agregado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateClient(@RequestBody ClientDTO clientDTO) {
        int result = clientService.updateClient(
            clientDTO.getIdClient(),
            clientDTO.getIdPerson(),
            clientDTO.getIdTypeClient(),
            clientDTO.getIdHealthQuestionnaire(),
            clientDTO.getIdUser(),
            clientDTO.getRegistrationDate(),
            clientDTO.getEmergencyContact(),
            clientDTO.getSignatureImage(),
            clientDTO.getParamLoggedIdUser()
        );

        switch(result) {
            case 1 -> { 
                ApiResponse<String> response = new ApiResponse<>("Cliente actualizado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            case 0 -> throw new AppException("Ocurrió un error al actualizar el cliente.", HttpStatus.INTERNAL_SERVER_ERROR);
            case -1 -> throw new AppException("No se pudo actualizar el cliente porque no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);
            default -> throw new AppException("Cliente no actualizado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{idClient}")
    public ResponseEntity<ApiResponse<String>> deleteClient(@PathVariable("idClient") Long idClient, @RequestBody ParamLoggedIdUserDTO paramLoggedIdUser) {
        int result = clientService.deleteClient(idClient, paramLoggedIdUser.getParamLoggedIdUser());

        switch(result) {
            case 1 -> { 
                ApiResponse<String> response = new ApiResponse<>("Cliente eliminado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            case 0 -> throw new AppException("Ocurrió un error al eliminar el cliente.", HttpStatus.INTERNAL_SERVER_ERROR);
            case -1 -> throw new AppException("No se pudo eliminar el cliente porque no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);
            default -> throw new AppException("Cliente no eliminado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
