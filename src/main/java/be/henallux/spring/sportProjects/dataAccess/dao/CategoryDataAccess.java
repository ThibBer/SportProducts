package be.henallux.spring.sportProjects.dataAccess.dao;


import be.henallux.spring.sportProjects.model.Category;

import java.util.ArrayList;

public interface CategoryDataAccess {
    ArrayList<Category> getCategories();
}