package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.model.Product;

import java.util.ArrayList;

public interface ProductDataAccess {
    ArrayList<Product> getProductsWithCategoryId(int idCategory);
    Product getProductWithId(int idProduct);
}
