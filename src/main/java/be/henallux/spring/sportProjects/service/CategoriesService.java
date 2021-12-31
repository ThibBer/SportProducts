package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.CategoryDataAccess;
import be.henallux.spring.sportProjects.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoriesService {
    private CategoryDataAccess categoryDataAccess;
    private ArrayList<Category> categories;
    private Category category;

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
}
