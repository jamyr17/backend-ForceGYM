package una.force_gym.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import una.force_gym.domain.ProductInventory;

import org.springframework.data.jpa.repository.Query;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Long>{
    
    @Procedure(procedureName = "prGetProductInventory")
    List<ProductInventory> getProductsInventory(@Param("p_page") int p_page, @Param("p_limit") int p_limit);

    Long countByIsDeleted(Long isDeleted);

    @Procedure(procedureName = "prInsertProductInventory", outputParameterName = "result")
    int addProductInventory(@Param("pIdUser") Long pIdUser, @Param("pCode") String pCode, @Param("pName") String pName, @Param("pQuantity") int pQuantity, @Param("pCost") Float pCost, @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prUpdateProductInventory", outputParameterName = "result")
    int updateProductInventory(@Param("pIdProductInventory") Long pIdProductInventory, @Param("pIdUser") Long pIdUser, @Param("pCode") String pCode, @Param("pName") String pName, @Param("pQuantity") int pQuantity, @Param("pCost") Float pCost, @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prDeleteProductInventory")
    int deleteProductInventory(@Param("pIdProductInventory") Long pIdProductInventory, @Param("pLoggedIdUser") Long pLoggedIdUser);

    @Procedure(procedureName = "prGetProductInventoryByCostRange")
    List<ProductInventory> getProductInventoryByCostRange(@Param("minCost") double minCost, @Param("maxCost") double maxCost, @Param("p_page") int p_page, @Param("p_limit") int p_limit);

    @Procedure(procedureName = "prGetProductInventoryByQuantityRange")
    List<ProductInventory> getProductInventoryByQuantityRange(@Param("minQuantity") int minQuantity, @Param("maxQuantity") int maxQuantity, @Param("p_page") int p_page, @Param("p_limit") int p_limit);
    
    @Query("SELECT COUNT(p) FROM ProductInventory p WHERE p.cost >= :minCost AND p.cost <= :maxCost AND p.isDeleted = 0")
    Long countProductInventoryByCostRange(@Param("minCost") double minCost, @Param("maxCost") double maxCost);

    @Query("SELECT COUNT(p) FROM ProductInventory p WHERE p.quantity >= :minQuantity AND p.quantity <= :maxQuantity AND p.isDeleted = 0")
    Long countProductInventoryByQuantityRange(@Param("minQuantity") int minQuantity, @Param("maxQuantity") int maxQuantity);

    @Query(value = "SELECT * FROM tbProductInventory p WHERE p.isDeleted = 0 AND " +
               "LOWER(p.code) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
               "LIMIT :size OFFSET :offset", nativeQuery = true)
    List<ProductInventory> searchProductsInventory(@Param("searchTerm") String searchTerm, @Param("offset") int offset, @Param("size") int size);

    @Query(value = "SELECT COUNT(*) FROM tbProductInventory p WHERE p.isDeleted = 0 AND " +
                "LOWER(p.code) LIKE LOWER(CONCAT('%', :searchTerm, '%'))", nativeQuery = true)
    Long countBySearchTerm(@Param("searchTerm") String searchTerm);



}
