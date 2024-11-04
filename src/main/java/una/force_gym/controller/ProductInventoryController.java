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

import una.force_gym.domain.ProductInventory;
import una.force_gym.dto.ParamLoggedIdUserDTO;
import una.force_gym.dto.ProductInventoryDTO;
import una.force_gym.exception.AppException;
import una.force_gym.service.ProductInventoryService;
import una.force_gym.util.ApiResponse;

@RestController
@RequestMapping("/productInventory")
public class ProductInventoryController {
    
    @Autowired
    private ProductInventoryService productInventoryService;

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getProductInventorys(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size) {
        try {
            List<ProductInventory> productsInventory = productInventoryService.getProductsInventory(page, size);
            Long totalRecords = productInventoryService.countActiveProductsInventory();

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("productsInventory", productsInventory);
            responseData.put("totalRecords", totalRecords);

            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Productos de inventario obtenidos correctamente.", responseData);
            return new ResponseEntity<>(response, HttpStatus.OK); 

        } catch (RuntimeException e) {
            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Ocurrió un error al solicitar los datos de los productos de inventario.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    }
    
    @PostMapping("/add")
    public ResponseEntity<ApiResponse<String>> addProductInventory(@RequestBody ProductInventoryDTO productInventoryDTO) {
        int result = productInventoryService.addProductInventory(
            productInventoryDTO.getIdUser(), 
            productInventoryDTO.getCode(), 
            productInventoryDTO.getName(), 
            productInventoryDTO.getQuantity(), 
            productInventoryDTO.getCost(),  
            productInventoryDTO.getParamLoggedIdUser()
        );

        switch(result) {
            case 1 -> 
            { 
                ApiResponse<String> response = new ApiResponse<>("Producto de inventario agregado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK); 
            }

            // error de MySQL
            case 0 -> throw new AppException("Ocurrió un error al agregar el nuevo producto de inventario.", HttpStatus.INTERNAL_SERVER_ERROR);
            
            // no se encuentra el idUser
            case -1 -> throw new AppException("No se pudo agregar el nuevo producto de inventario debido a que el usuario asociado no está registrado.", HttpStatus.INTERNAL_SERVER_ERROR);
            
            default -> throw new AppException("Producto de inventario no agregado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<String>> updateProductInventory(@RequestBody ProductInventoryDTO productInventoryDTO) {
        int result = productInventoryService.updateProductInventory(
            productInventoryDTO.getIdProductInventory(), 
            productInventoryDTO.getIdUser(), 
            productInventoryDTO.getCode(), 
            productInventoryDTO.getName(), 
            productInventoryDTO.getQuantity(), 
            productInventoryDTO.getCost(),  
            productInventoryDTO.getParamLoggedIdUser()
        );

        switch(result) {
            case 1 -> 
            { 
                ApiResponse<String> response = new ApiResponse<>("Producto de inventario actualizado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK); 
            }

            // error de MySQL
            case 0 -> throw new AppException("Ocurrió un error al actualizar el producto de inventario.", HttpStatus.INTERNAL_SERVER_ERROR);

            // no se encuentra el idProductInventory
            case -1 -> throw new AppException("No se pudo actualizar el producto de inventario debido a que no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);

            // no se encuentra el idUser
            case -2 -> throw new AppException("No se pudo actualizar el producto de inventario debido a que el usuario asociado no está registrado.", HttpStatus.INTERNAL_SERVER_ERROR);
            
            default -> throw new AppException("Producto de inventario no actualizado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete/{idProductInventory}")
    public ResponseEntity<ApiResponse<String>> deleteProductInventory(@PathVariable("idProductInventory") Long idProductInventory, @RequestBody ParamLoggedIdUserDTO paramLoggedIdUser) {
        int result = productInventoryService.deleteProductInventory(idProductInventory, paramLoggedIdUser.getParamLoggedIdUser());
       
        switch(result) {
            case 1 -> 
            { 
                ApiResponse<String> response = new ApiResponse<>("Producto de inventario eliminado correctamente.", null);
                return new ResponseEntity<>(response, HttpStatus.OK); 
            }

            // error de MySQL
            case 0 -> throw new AppException("Ocurrió un error al eliminar el producto de inventario.", HttpStatus.INTERNAL_SERVER_ERROR);

            // no se encuentra el idProductInventory
            case -1 -> throw new AppException("No se pudo eliminar el producto de inventario debido a que no se encuentra el registro.", HttpStatus.INTERNAL_SERVER_ERROR);

            default -> throw new AppException("Producto de inventario no eliminado debido a problemas en la consulta.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/inventoryByCostRange")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getProductInventoryByCostRange(
        @RequestParam("minCost") double minCost,
        @RequestParam("maxCost") double maxCost,
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size) {
        try {
            List<ProductInventory> products = productInventoryService.getProductInventoryByCostRange(minCost, maxCost, page, size);
            Long totalRecords = (long) products.size();

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("products", products);
            responseData.put("totalRecords", totalRecords);

            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Inventario filtrado por rango de costo obtenido correctamente.", responseData);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Error al obtener inventario por rango de costo.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/inventoryByQuantityRange")
    public ResponseEntity<ApiResponse<Map<String, Object>>> getProductInventoryByQuantityRange(
        @RequestParam("minQuantity") int minQuantity,
        @RequestParam("maxQuantity") int maxQuantity,
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size) {
        try {
            List<ProductInventory> products = productInventoryService.getProductInventoryByQuantityRange(minQuantity, maxQuantity, page, size);
            Long totalRecords = (long) products.size();

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("products", products);
            responseData.put("totalRecords", totalRecords);

            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Inventario filtrado por rango de cantidad obtenido correctamente.", responseData);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException e) {
            ApiResponse<Map<String, Object>> response = new ApiResponse<>("Error al obtener inventario por rango de cantidad.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
