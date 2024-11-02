package una.force_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.domain.ProductInventory;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Long>{
    
    @Procedure(procedureName = "prGetProductInventory")
    List<ProductInventory> getProductsInventory(@Param("p_page") int p_page, @Param("p_limit") int p_limit);

    @Procedure(procedureName = "prInsertProductInventory", outputParameterName = "result")
    int addProductInventory(@Param("pIdUser") Long pIdUser, @Param("pCode") String pCode, @Param("pName") String pName, @Param("pQuantity") int pQuantity, @Param("pCost") Float pCost, @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prUpdateProductInventory", outputParameterName = "result")
    int updateProductInventory(@Param("pIdProductInventory") Long pIdProductInventory, @Param("pIdUser") Long pIdUser, @Param("pCode") String pCode, @Param("pName") String pName, @Param("pQuantity") int pQuantity, @Param("pCost") Float pCost, @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prDeleteProductInventory")
    int deleteProductInventory(@Param("pIdProductInventory") Long pIdProductInventory, @Param("pLoggedIdUser") Long pLoggedIdUser);

}
