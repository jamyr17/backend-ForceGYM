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

import una.force_gym.domain.HealthQuestionnaire;
import una.force_gym.dto.HealthQuestionnaireDTO;
import una.force_gym.dto.ParamLoggedIdUserDTO;
import una.force_gym.exception.AppException;
import una.force_gym.service.HealthQuestionnaireService;
import una.force_gym.util.ApiResponse;

@RestController
@RequestMapping("/healthQuestionnaire")
public class HealthQuestionnaireController {
    
    @Autowired
    private HealthQuestionnaireService healthQuestionnaireService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getHealthQuestionnaires(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size) {
        try {
            List<HealthQuestionnaire> healthQuestionnaires = healthQuestionnaireService.getHealthQuestionnaires(page, size);
            Long totalRecords = healthQuestionnaireService.countActiveHealthQuestionnaires();

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("healthQuestionnaires", healthQuestionnaires);
            responseData.put("totalRecords", totalRecords);

            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Cuestionarios de salud obtenidos correctamente.", responseData);
            return new ResponseEntity<>(response, HttpStatus.OK); 

        } catch (RuntimeException e) {
            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Ocurrió un error al obtener los cuestionarios de salud.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    }
    
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addHealthQuestionnaire(@RequestBody HealthQuestionnaireDTO healthQuestionnaireDTO) {
        int result = healthQuestionnaireService.addHealthQuestionnaire(
            healthQuestionnaireDTO.getIdClient(), 
            healthQuestionnaireDTO.getDiabetes(), 
            healthQuestionnaireDTO.getHypertension(), 
            healthQuestionnaireDTO.getMuscleInjuries(), 
            healthQuestionnaireDTO.getBoneJointIssues(),  
            healthQuestionnaireDTO.getBalanceLoss(), 
            healthQuestionnaireDTO.getCardiovascularDisease(), 
            healthQuestionnaireDTO.getBreathingIssues(),
            healthQuestionnaireDTO.getParamLoggedIdUser()
        );

        switch(result) {
            case 1 -> { 
                ApiResponse<String> response = new ApiResponse<>("Cuestionario de salud agregado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK); 
            }

            case 0 -> throw new AppException("Ocurrió un error al agregar el cuestionario de salud.", HttpStatus.INTERNAL_SERVER_ERROR);
            
            case -1 -> throw new AppException("No se pudo agregar el cuestionario de salud porque el cliente asociado no está registrado.", HttpStatus.INTERNAL_SERVER_ERROR);
            
            default -> throw new AppException("Cuestionario de salud no agregado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateHealthQuestionnaire(@RequestBody HealthQuestionnaireDTO healthQuestionnaireDTO) {
        int result = healthQuestionnaireService.updateHealthQuestionnaire(
            healthQuestionnaireDTO.getIdHealthQuestionnaire(), 
            healthQuestionnaireDTO.getDiabetes(), 
            healthQuestionnaireDTO.getHypertension(), 
            healthQuestionnaireDTO.getMuscleInjuries(), 
            healthQuestionnaireDTO.getBoneJointIssues(),  
            healthQuestionnaireDTO.getBalanceLoss(), 
            healthQuestionnaireDTO.getCardiovascularDisease(), 
            healthQuestionnaireDTO.getBreathingIssues(),  
            healthQuestionnaireDTO.getParamLoggedIdUser()
        );

        switch(result) {
            case 1 -> { 
                ApiResponse<String> response = new ApiResponse<>("Cuestionario de salud actualizado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK); 
            }

            case 0 -> throw new AppException("Ocurrió un error al actualizar el cuestionario de salud.", HttpStatus.INTERNAL_SERVER_ERROR);

            case -1 -> throw new AppException("No se pudo actualizar el cuestionario de salud porque no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);

            default -> throw new AppException("Cuestionario de salud no actualizado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{idHealthQuestionnaire}")
    public ResponseEntity<ApiResponse<String>> deleteHealthQuestionnaire(
        @PathVariable("idHealthQuestionnaire") Long idHealthQuestionnaire,
        @RequestBody ParamLoggedIdUserDTO paramLoggedIdUser) {

        int result = healthQuestionnaireService.deleteHealthQuestionnaire(idHealthQuestionnaire, paramLoggedIdUser.getParamLoggedIdUser());

        switch(result) {
            case 1 -> { 
                ApiResponse<String> response = new ApiResponse<>("Cuestionario de salud eliminado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK); 
            }

            case 0 -> throw new AppException("Ocurrió un error al eliminar el cuestionario de salud.", HttpStatus.INTERNAL_SERVER_ERROR);

            case -1 -> throw new AppException("No se pudo eliminar el cuestionario de salud porque no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);

            default -> throw new AppException("Cuestionario de salud no eliminado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
