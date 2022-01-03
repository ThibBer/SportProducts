package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.ProductDataAccess;
import be.henallux.spring.sportProjects.model.Category;
import be.henallux.spring.sportProjects.model.Product;
import be.henallux.spring.sportProjects.model.Promotion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ShoppingCartServiceTest {
    private ShoppingCartService shoppingCartService;
    private ProductsService productsService;

    @Mock
    private ProductDataAccess productDAO;

    @Mock
    private LanguageService languageService;

    @Mock
    private TranslationService translationService;

    @Before
    public void setUp() {
        shoppingCartService = new ShoppingCartService();
        productsService = new ProductsService(productDAO, languageService, translationService);
    }

    @Test
    public void getTotalPrice() {
        HashMap<Product, Integer> products = new HashMap<>();
        Date now = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(now);
        c.add(Calendar.DATE, 1);
        Date tomorrow = c.getTime();
        Promotion promotion = new Promotion(1, now, tomorrow, 10);

        Category catWithPromo = new Category(1, "Category", "Descrition cat", "image.png", promotion);
        Category cat = new Category(2, "Category 2", "Descrition cat 2", "image2.png", null);

        Product product = new Product(1, 10.0, catWithPromo, "description", "image.png");
        if(product.getCategory().isInPromotion()){
            product.setPriceWithPromotion(productsService.priceWithPromotion(product.getPrice(), product.getCategory().getPromotion().getPercentage()));
        }
        products.put(product, 5);

        Product product2 = new Product(2, 20.0, cat, "description", "image.png");
        if(product2.getCategory().isInPromotion()){
            product2.setPriceWithPromotion(productsService.priceWithPromotion(product2.getPrice(), product2.getCategory().getPromotion().getPercentage()));
        }
        products.put(product2, 10);

        Assert.assertEquals(245.0, shoppingCartService.getTotalPrice(products), 0.01);
    }
}