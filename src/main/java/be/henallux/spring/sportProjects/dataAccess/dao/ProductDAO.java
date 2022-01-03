package be.henallux.spring.sportProjects.dataAccess.dao;

import be.henallux.spring.sportProjects.dataAccess.entity.CategoryEntity;
import be.henallux.spring.sportProjects.dataAccess.entity.ProductEntity;
import be.henallux.spring.sportProjects.dataAccess.repository.ProductRepository;
import be.henallux.spring.sportProjects.dataAccess.util.ProviderConverter;
import be.henallux.spring.sportProjects.model.Category;
import be.henallux.spring.sportProjects.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductDAO implements ProductDataAccess {
    private ProductRepository productRepository;
    private ProviderConverter converter;

    @Autowired
    public ProductDAO(ProductRepository productRepository, ProviderConverter converter) {
        this.productRepository = productRepository;
        this.converter = converter;
    }

    @Override
    public ArrayList<Product> getProductsWithCategoryId(int idCategory) {
        List<ProductEntity> productEntities = productRepository.findProductEntitiesByCategoryEntityId(idCategory);
        ArrayList<Product> products = new ArrayList<>();

        for(ProductEntity productEntity : productEntities) {
            products.add(converter.productEntityToProductModel(productEntity));
        }

        return products;
    }

    @Override
    public Product getProductWithId(int idProduct) {
        ProductEntity productEntity = productRepository.findProductEntityById(idProduct);
        Product product = converter.productEntityToProductModel(productEntity);
        return product;
    }

    @Override
    public ArrayList<Product> getNumberRandomProducts(int numberProducts) {
        Long count = productRepository.count();
        int numPage = (int)(Math.random() * (count / numberProducts));
        PageRequest pageRequest = PageRequest.of(numPage, numberProducts);
        Page<ProductEntity> productEntities = productRepository.findAll(pageRequest);
        ArrayList<Product> products = new ArrayList<>();

        for(ProductEntity productEntity: productEntities.toList()){
            products.add(converter.productEntityToProductModel(productEntity));
        }

        return products;
    }
}
