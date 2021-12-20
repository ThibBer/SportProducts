package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.ProductDataAccess;
import be.henallux.spring.sportProjects.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductsService {
    private ProductDataAccess productDAO;
    private ArrayList<Product> products;
    private Product product;

    @Autowired
    public ProductsService(ProductDataAccess productDAO) {
        this.productDAO = productDAO;
    }

    public ArrayList<Product> getProductsWithCategoryId(int idCategory) {
        products = productDAO.getProductsWithCategoryId(idCategory);
        return products;
    }

    public Product getProductWithId(int idProduct) {
        product = productDAO.getProductWithId(idProduct);
        return product;
    }
}
