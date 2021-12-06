package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.dataAccess.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductDAO implements ProductDataAccess {
    private ProductRepository repository;

    @Autowired
    public ProductDAO(ProductRepository repository) {
        this.repository = repository;
    }
}
