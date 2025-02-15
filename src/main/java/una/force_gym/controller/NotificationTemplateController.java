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

import una.force_gym.domain.NotificationTemplate;
import una.force_gym.dto.NotificationTemplateDTO;
import una.force_gym.dto.ParamLoggedIdUserDTO;
import una.force_gym.exception.AppException;
import una.force_gym.service.NotificationTemplateService;
import una.force_gym.util.ApiResponse;

@RestController
@RequestMapping("/notificationTemplate")
public class NotificationTemplateController {
   
    @Autowired
    private NotificationTemplateService notificationTemplateService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getNotificationTemplates(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size) {
        try {
            List<NotificationTemplate> NotificationTemplates = notificationTemplateService.getNotificationTemplates(page, size);
            Long totalRecords = notificationTemplateService.countActiveNotificationTemplates();

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("NotificationTemplates", NotificationTemplates);
            responseData.put("totalRecords", totalRecords);

            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Tipos de notificación obtenidos correctamente.", responseData);
            return new ResponseEntity<>(response, HttpStatus.OK); 

        } catch (RuntimeException e) {
            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Ocurrió un error al solicitar los datos de los ingresos económicos.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    }
    
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addNotificationTemplate(@RequestBody NotificationTemplateDTO notificationTemplateDTO) {
        int result = notificationTemplateService.addNotificationTemplate(
            notificationTemplateDTO.getIdNotificationType(), 
            notificationTemplateDTO.getIdUser(), 
            notificationTemplateDTO.getMessage(), 
            notificationTemplateDTO.getParamLoggedIdUser()
        );

        switch(result) {
            case 1 -> 
            { 
                ApiResponse<String> response = new ApiResponse<>("Tipo notificacion agregado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK); 
            }

            // error de MySQL
            case 0 -> throw new AppException("Ocurrió un error al agregar el nuevo tipo notificacion.", HttpStatus.INTERNAL_SERVER_ERROR);
            
            // no se encuentra el idUser
            case -1 -> throw new AppException("No se pudo agregar el nuevo tipo notificacion debido a que el usuario asociado no está registrado.", HttpStatus.INTERNAL_SERVER_ERROR);
            
            default -> throw new AppException("Tipo notificacion no agregado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateNotificationTemplate(@RequestBody NotificationTemplateDTO notificationTemplateDTO) {
        int result = notificationTemplateService.updateNotificationTemplate(
            notificationTemplateDTO.getIdNotificationTemplate(), 
            notificationTemplateDTO.getIdNotificationType(), 
            notificationTemplateDTO.getIdUser(), 
            notificationTemplateDTO.getMessage(), 
            notificationTemplateDTO.getParamLoggedIdUser()
        );

        switch(result) {
            case 1 -> 
            { 
                ApiResponse<String> response = new ApiResponse<>("Tipo notificacion actualizado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK); 
            }

            // error de MySQL
            case 0 -> throw new AppException("Ocurrió un error al actualizar el tipo notificacion.", HttpStatus.INTERNAL_SERVER_ERROR);

            // no se encuentra el idNotificationTemplate
            case -1 -> throw new AppException("No se pudo actualizar el tipo notificacion debido a que no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);

            // no se encuentra el idUser
            case -2 -> throw new AppException("No se pudo actualizar el tipo notificacion debido a que el usuario asociado no está registrado.", HttpStatus.INTERNAL_SERVER_ERROR);
            
            default -> throw new AppException("Tipo notificacion no actualizado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete/{idNotificationTemplate}")
    public ResponseEntity<ApiResponse<String>> deleteNotificationTemplate(@PathVariable("idNotificationTemplate") Long idNotificationTemplate, @RequestBody ParamLoggedIdUserDTO paramLoggedIdUser) {
        int result = notificationTemplateService.deleteNotificationTemplate(idNotificationTemplate, paramLoggedIdUser.getParamLoggedIdUser());
       
        switch(result) {
            case 1 -> 
            { 
                ApiResponse<String> response = new ApiResponse<>("Tipo notificacion eliminado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK); 
            }

            // error de MySQL
            case 0 -> throw new AppException("Ocurrió un error al eliminar el tipo notificacion.", HttpStatus.INTERNAL_SERVER_ERROR);

            // no se encuentra el idNotificationTemplate
            case -1 -> throw new AppException("No se pudo eliminar el tipo notificacion debido a que no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);

            default -> throw new AppException("Tipo notificacion no eliminado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    } 
}
