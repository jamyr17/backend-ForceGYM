package una.force_gym.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import una.force_gym.domain.EconomicExpense;
import una.force_gym.dto.EconomicExpenseDTO;
import una.force_gym.dto.ParamLoggedIdUserDTO;
import una.force_gym.exception.AppException;
import una.force_gym.service.EconomicExpenseService;
import una.force_gym.util.ApiResponse;


@RestController
@RequestMapping("/economicExpense")
public class EconomicExpenseController {

    @Autowired
    private EconomicExpenseService economicExpenseService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<EconomicExpense>>> getEconomicExpenses() {
        try {
            List<EconomicExpense> economicExpenses = economicExpenseService.getEconomicExpenses();
            ApiResponse<List<EconomicExpense>> response = new ApiResponse<>("Gastos económicos obtenidos correctamente.", economicExpenses);
            return new ResponseEntity<>(response, HttpStatus.OK); 

        } catch (RuntimeException e) {
            ApiResponse<List<EconomicExpense>> response = new ApiResponse<>("Ocurrió un error al solicitar los datos de los gastos económicos.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addEconomicExpense(@RequestBody EconomicExpenseDTO economicExpenseDTO) {
        int result = economicExpenseService.addEconomicExpense(
            economicExpenseDTO.getIdUser(), 
            economicExpenseDTO.getRegistrationDate(), 
            economicExpenseDTO.getVoucherNumber(), 
            economicExpenseDTO.getDetail(), 
            economicExpenseDTO.getIdMeanOfPayment(), 
            economicExpenseDTO.getAmount(), 
            economicExpenseDTO.getParamLoggedIdUser()
        );

        switch (result) {
            case 1 -> {
                ApiResponse<String> response = new ApiResponse<>("Gasto económico agregado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            case 0 -> throw new AppException("Ocurrió un error al agregar el nuevo gasto económico.", HttpStatus.INTERNAL_SERVER_ERROR);

            case -1 -> throw new AppException("No se pudo agregar el nuevo gasto económico debido a que el usuario asociado no está registrado.", HttpStatus.INTERNAL_SERVER_ERROR);

            default -> throw new AppException("Gasto económico no agregado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateEconomicExpense(@RequestBody EconomicExpenseDTO economicExpenseDTO) {
        int result = economicExpenseService.updateEconomicExpense(
            economicExpenseDTO.getIdEconomicExpense(),
            economicExpenseDTO.getIdUser(),
            economicExpenseDTO.getRegistrationDate(),
            economicExpenseDTO.getVoucherNumber(),
            economicExpenseDTO.getDetail(),
            economicExpenseDTO.getIdMeanOfPayment(),
            economicExpenseDTO.getAmount(),
            economicExpenseDTO.getParamLoggedIdUser()
        );

        switch (result) {
            case 1 -> {
                ApiResponse<String> response = new ApiResponse<>("Gasto económico actualizado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            case 0 -> throw new AppException("Ocurrió un error al actualizar el gasto económico.", HttpStatus.INTERNAL_SERVER_ERROR);

            case -1 -> throw new AppException("No se pudo actualizar el gasto económico debido a que no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);

            case -2 -> throw new AppException("No se pudo actualizar el gasto económico debido a que el usuario asociado no está registrado.", HttpStatus.INTERNAL_SERVER_ERROR);

            default -> throw new AppException("Gasto económico no actualizado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete/{idEconomicExpense}")
    public ResponseEntity<ApiResponse<String>> deleteEconomicExpense(@PathVariable("idEconomicExpense") Long idEconomicExpense, @RequestBody ParamLoggedIdUserDTO paramLoggedIdUser) {
        int result = economicExpenseService.deleteEconomicExpense(idEconomicExpense, paramLoggedIdUser.getParamLoggedIdUser());
        
        switch (result) {
            case 1 -> {
                ApiResponse<String> response = new ApiResponse<>("Gasto económico eliminado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK);
            }

            case 0 -> throw new AppException("Ocurrió un error al eliminar el gasto económico.", HttpStatus.INTERNAL_SERVER_ERROR);

            case -1 -> throw new AppException("No se pudo eliminar el gasto económico debido a que no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);

            default -> throw new AppException("Gasto económico no eliminado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
