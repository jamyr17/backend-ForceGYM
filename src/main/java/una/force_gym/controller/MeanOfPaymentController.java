package una.force_gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import una.force_gym.domain.MeanOfPayment;
import una.force_gym.service.MeanOfPaymentService;
import una.force_gym.util.ApiResponse;

@RestController
@RequestMapping("/meanOfPayment")
public class MeanOfPaymentController {
    
    @Autowired
    private MeanOfPaymentService meanOfPaymentService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<MeanOfPayment>>> getRoles() {
        try {
            List<MeanOfPayment> meansOfPayment = meanOfPaymentService.getMeansOfPayment();
            ApiResponse<List<MeanOfPayment>> response = new ApiResponse<>("Métodos de pago obtenidos correctamente.", meansOfPayment);
            return new ResponseEntity<>(response, HttpStatus.OK); 

        } catch (RuntimeException e) {
            ApiResponse<List<MeanOfPayment>> response = new ApiResponse<>("Ocurrió un error al solicitar los datos de los métodos de pago.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }

    }

}
