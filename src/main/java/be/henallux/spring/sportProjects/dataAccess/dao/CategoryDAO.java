package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.dataAccess.entity.CategoryEntity;
import be.henallux.spring.sportProjects.dataAccess.repository.CategoryRepository;
import be.henallux.spring.sportProjects.dataAccess.util.ProviderConverter;
import be.henallux.spring.sportProjects.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryDAO implements CategoryDataAccess {
    private CategoryRepository repository;
    private ProviderConverter converter;

    @Autowired
    public CategoryDAO(CategoryRepository repository, ProviderConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public ArrayList<Category> getCategories() {
        List<CategoryEntity> categoryEntities = repository.findAll();
        System.out.println(categoryEntities);
        ArrayList<Category> categories = new ArrayList<>();

        for(CategoryEntity categoryEntity: categoryEntities){
            categories.add(converter.categoryEntityToCategoryModel(categoryEntity));
        }

        return categories;
    }
}
