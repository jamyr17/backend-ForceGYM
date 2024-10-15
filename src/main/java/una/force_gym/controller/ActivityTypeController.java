package una.force_gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import una.force_gym.domain.ActivityType;
import una.force_gym.service.ActivityTypeService;
import una.force_gym.util.ApiResponse;

@RestController
@RequestMapping("/activityType")
public class ActivityTypeController {
    
    @Autowired
    private ActivityTypeService activityTypeService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<ActivityType>>> getRoles() {
        try {
            List<ActivityType> activityTypes = activityTypeService.getActivityTypes();
            ApiResponse<List<ActivityType>> response = new ApiResponse<>("Tipos de actividad obtenidos correctamente.", activityTypes);
            return new ResponseEntity<>(response, HttpStatus.OK); 

        } catch (RuntimeException e) {
            ApiResponse<List<ActivityType>> response = new ApiResponse<>("Ocurrió un error al solicitar los datos de los tipos de actividad.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }

    }

}
