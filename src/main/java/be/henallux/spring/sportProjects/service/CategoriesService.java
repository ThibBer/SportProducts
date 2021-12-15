package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.CategoryDAO;
import be.henallux.spring.sportProjects.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoriesService {
    private CategoryDAO categoryDAO;
    private ArrayList<Category> categories;
    private Category category;

    @Autowired
    public CategoriesService(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    public ArrayList<Category> getCategories() {
        categories = categoryDAO.getCategories();
        return categories;
    }

    public Category getCategoryWithId(int id) {
        category = categoryDAO.getCategoryWithId(id);
        return category;
    }
}
