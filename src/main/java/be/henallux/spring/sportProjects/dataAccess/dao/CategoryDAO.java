package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.dataAccess.entity.CategoryEntity;
import be.henallux.spring.sportProjects.dataAccess.repository.CategoryRepository;
import be.henallux.spring.sportProjects.dataAccess.util.ProviderConverter;
import be.henallux.spring.sportProjects.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryDAO implements CategoryDataAccess {
    private CategoryRepository categoryRepository;
    private ProviderConverter converter;

    @Autowired
    public CategoryDAO(CategoryRepository repository, ProviderConverter converter) {
        this.categoryRepository = repository;
        this.converter = converter;
    }

    @Override
    public ArrayList<Category> getCategories() {
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        ArrayList<Category> categories = new ArrayList<>();

        for(CategoryEntity categoryEntity: categoryEntities){
            categories.add(converter.categoryEntityToCategoryModel(categoryEntity));
        }

        return categories;
    }

    @Override
    public Category getCategoryWithId(int id) {
        CategoryEntity categoryEntity = categoryRepository.findCategoryEntityById(id);
        Category category = converter.categoryEntityToCategoryModel(categoryEntity);
        return category;
    }

    @Override
    public ArrayList<Category> getNumberRandomCategories(int number) {
        Long count = categoryRepository.count();
        int numPage = (int)(Math.random() * (count / number));
        PageRequest pageRequest = PageRequest.of(numPage, number);
        Page<CategoryEntity> categoryEntities = categoryRepository.findAll(pageRequest);
        ArrayList<Category> categories = new ArrayList<>();

        for(CategoryEntity categoryEntity: categoryEntities.toList()){
            categories.add(converter.categoryEntityToCategoryModel(categoryEntity));
        }

        return categories;
    }
}
