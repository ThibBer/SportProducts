package be.henallux.spring.sportProjects.dataAccess.repository;

import be.henallux.spring.sportProjects.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    List<ProductEntity> findProductEntitiesByCategoryEntityId(Integer id);
    ProductEntity findProductEntityById(Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM product ORDER BY RAND() LIMIT ?1")
    List<ProductEntity> getRandomProducts(Integer limit);

}
