package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.model.Product;

import java.util.ArrayList;
import java.util.Locale;

public interface ProductDataAccess {
    ArrayList<Product> getProductsWithCategoryId(int idCategory);
    Product getProductWithId(int idProduct);
}
