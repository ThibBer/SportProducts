package be.henallux.spring.sportProjects.dataAccess.repository;

import be.henallux.spring.sportProjects.dataAccess.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
