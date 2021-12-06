package be.henallux.spring.sportProjects.dataAccess.repository;

import be.henallux.spring.sportProjects.dataAccess.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
}