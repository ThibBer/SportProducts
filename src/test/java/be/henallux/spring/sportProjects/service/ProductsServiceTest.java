package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.ProductDAO;
import be.henallux.spring.sportProjects.dataAccess.dao.ProductDataAccess;
import be.henallux.spring.sportProjects.dataAccess.entity.CategoryEntity;
import be.henallux.spring.sportProjects.dataAccess.entity.ProductEntity;
import be.henallux.spring.sportProjects.dataAccess.repository.ProductRepository;
import be.henallux.spring.sportProjects.dataAccess.util.ProviderConverter;
import be.henallux.spring.sportProjects.model.Category;
import be.henallux.spring.sportProjects.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ProductsServiceTest {
    private ProductsService productsService;
    private ProductDataAccess productDAO;
    private ProviderConverter providerConverter;

    @Mock
    private LanguageService languageService;

    @Mock
    private TranslationService translationService;

    @Mock
    private ProductRepository productRepository;

    @Before
    public void setUp() {
        providerConverter = new ProviderConverter();
        productDAO = new ProductDAO(productRepository, providerConverter);
        productsService = new ProductsService(productDAO, languageService, translationService);
    }

    @Test
    public void getProductsWithCategoryId() {
        ArrayList<ProductEntity> productsEntities = new ArrayList<>();

        CategoryEntity categoryEntity = new CategoryEntity(1, "Category", "Descrition cat", "image.png", null);

        ProductEntity productEntity = new ProductEntity(1, 10.0, categoryEntity, "description", "image.png");
        productsEntities.add(productEntity);

        ProductEntity product2Entity = new ProductEntity(2, 20.0, categoryEntity, "description 2", "image2.png");
        productsEntities.add(product2Entity);

        when(productRepository.findProductEntitiesByCategoryEntityId(1)).thenReturn(productsEntities);


        ArrayList<Product> products = new ArrayList<>();

        Category cat = new Category(1, "Category", "Descrition cat", "image.png", null);

        Product product = new Product(1, 10.0, cat, "description", "image.png");
        products.add(product);

        Product product2 = new Product(2, 20.0, cat, "description 2", "image2.png");
        products.add(product2);

        assertThat(productDAO.getProductsWithCategoryId(1)).isEqualTo(products);
    }

    @Test
    public void getProductWithId(){
        CategoryEntity categoryEntity = new CategoryEntity(1, "Category", "Descrition cat", "image.png", null);
        ProductEntity productEntity = new ProductEntity(1, 10.0, categoryEntity, "description", "image.png");

        when(productRepository.findProductEntityById(1)).thenReturn(productEntity);

        Category cat = new Category(1, "Category", "Descrition cat", "image.png", null);
        Product product = new Product(1, 10.0, cat, "description", "image.png");

        assertThat(productDAO.getProductWithId(1)).isEqualTo(product);
    }

    @Test
    public void priceWithPromotion() {
        double price = 47.5;
        int promotionPercentage = 15;

        Assert.assertEquals(40.375, productsService.priceWithPromotion(price, promotionPercentage), 0.01);
    }
}