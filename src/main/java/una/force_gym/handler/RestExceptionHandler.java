package una.force_gym.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import una.force_gym.exception.AppException;
import una.force_gym.util.ApiResponse;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = { AppException.class })
    @ResponseBody
    public ResponseEntity<ApiResponse<Object>> handleException(AppException ex) {
        return ResponseEntity
                .status(ex.getStatus())
                .body(new ApiResponse<>(ex.getMessage(), null));
    }
    
}
