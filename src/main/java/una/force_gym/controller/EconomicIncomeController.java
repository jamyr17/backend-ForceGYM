package una.force_gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import una.force_gym.domain.EconomicIncome;
import una.force_gym.service.EconomicIncomeService;
import una.force_gym.util.ApiResponse;


@RestController
@RequestMapping("/economicIncome")
public class EconomicIncomeController {

    @Autowired
    private EconomicIncomeService economicIncomeService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<EconomicIncome>>> getEconomicIncomes() {
        try {
            List<EconomicIncome> economicIncomes = economicIncomeService.getEconomicIncomes();
            ApiResponse<List<EconomicIncome>> response = new ApiResponse<>("Ingresos económicos obtenidos correctamente.", economicIncomes);
            return new ResponseEntity<>(response, HttpStatus.OK); 

        } catch (RuntimeException e) {
            ApiResponse<List<EconomicIncome>> response = new ApiResponse<>("Ocurrió un error al solicitar los datos de los ingresos económicos.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    }
    
    // endpoint de add

    // endpoint de update

    @DeleteMapping("/delete/{idEconomicIncome}")
    public ResponseEntity<ApiResponse<String>> deleteEconomicIncome(@PathVariable("idEconomicIncome") Long idEconomicIncome, @RequestParam() Long paramLoggedIdUser) {

        try { 
            int result = economicIncomeService.deleteEconomicIncome(idEconomicIncome, paramLoggedIdUser);
            ApiResponse<String> response;

            switch(result){
                case 1 ->
                {
                    response = new ApiResponse<>("Ingreso económico eliminado correctamente.", null);
                    return new ResponseEntity<>(response, HttpStatus.OK); 
                }
                
                case 0 -> // error de mysql
                { 
                    response = new ApiResponse<>("Ocurrió un error al eliminar el ingreso económico.", null);
                }

                case -1 -> // no se encuentra el idEconomicIncome
                {    
                    response = new ApiResponse<>("No se pudo eliminar el ingreso económico debido a que no se encuentra el registro.", null);
                }

                default -> 
                {
                    throw new RuntimeException("Ingreso económico no eliminado debido a problemas en la consulta.");
                }
            }

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (RuntimeException e) {
            ApiResponse<String> response = new ApiResponse<>("Ocurrió un error al eliminar el ingreso económico.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }

    }

}
