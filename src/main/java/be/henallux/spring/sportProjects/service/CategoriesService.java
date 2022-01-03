package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.CategoryDataAccess;
import be.henallux.spring.sportProjects.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoriesService {
    private CategoryDataAccess categoryDataAccess;

    @Autowired
    public CategoriesService(CategoryDataAccess categoryDataAccess) {
        this.categoryDataAccess = categoryDataAccess;
    }

    public ArrayList<Category> getCategories() {
        return categoryDataAccess.getCategories();
    }

    public Category getCategoryWithId(int id) {
        return categoryDataAccess.getCategoryWithId(id);
    }

    public ArrayList<Category> getNumberRandomCategories(int number) {
        return categoryDataAccess.getNumberRandomCategories(number);
    }
}
