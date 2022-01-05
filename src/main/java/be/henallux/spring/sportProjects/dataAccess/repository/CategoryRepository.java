package be.henallux.spring.sportProjects.dataAccess.repository;

import be.henallux.spring.sportProjects.dataAccess.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    CategoryEntity findCategoryEntityById(Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM category ORDER BY RAND() LIMIT ?1")
    List<CategoryEntity> getRandomCategories(int number);
}