package be.henallux.spring.sportProjects.dataAccess.repository;

import be.henallux.spring.sportProjects.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    List<ProductEntity> findProductEntitiesByCategory_Id(Integer id);
    ProductEntity findProductEntityById(Integer id);
}
