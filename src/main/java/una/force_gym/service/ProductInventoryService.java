package una.force_gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import una.force_gym.domain.ProductInventory;
import una.force_gym.repository.ProductInventoryRepository;

@Service
public class ProductInventoryService {

    @Autowired
    private ProductInventoryRepository productInventoryRepo;

    @Transactional
    public List<ProductInventory> getProductsInventory(int page, int size){
        return productInventoryRepo.getProductsInventory(page, size);
    }

    public Long countActiveProductsInventory(){
        return productInventoryRepo.countByIsDeleted(Long.valueOf(0));
    }

    @Transactional
    public int addProductInventory(Long pIdUser, String code, String name, int quantity, Float cost, Long pLoggedIdUser){
        return productInventoryRepo.addProductInventory(pIdUser, code, name, quantity, cost, pLoggedIdUser);
    }

    @Transactional
    public int updateProductInventory(Long pIdProductInventory, Long pIdUser, String code, String name, int quantity, Float cost, Long pLoggedIdUser){
        return productInventoryRepo.updateProductInventory(pIdProductInventory, pIdUser, code, name, quantity, cost, pLoggedIdUser);
    }

    @Transactional
    public int deleteProductInventory(Long pIdProductInventory, Long pLoggedIdUser){
        return productInventoryRepo.deleteProductInventory(pIdProductInventory, pLoggedIdUser);
    }

    @Transactional
    public List<ProductInventory> getProductInventoryByCostRange(double minCost, double maxCost, int page, int size) {
        return productInventoryRepo.getProductInventoryByCostRange(minCost, maxCost, page, size);
    }

    @Transactional
    public List<ProductInventory> getProductInventoryByQuantityRange(int minQuantity, int maxQuantity, int page, int size) {
        return productInventoryRepo.getProductInventoryByQuantityRange(minQuantity, maxQuantity, page, size);
    }

    @Transactional
    public List<ProductInventory> searchProductsInventory(String searchTerm, int page, int size) {
        int offset = (page - 1) * size;  // Cálculo manual de offset
        return productInventoryRepo.searchProductsInventory(searchTerm, offset, size);
    }

    public Long countSearchProductsInventory(String searchTerm) {
        return productInventoryRepo.countBySearchTerm(searchTerm);
    }


}
