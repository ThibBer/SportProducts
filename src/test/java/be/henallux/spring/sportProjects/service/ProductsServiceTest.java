package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.ProductDataAccess;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ProductsServiceTest {
    private ProductsService productsService;

    @Mock
    private ProductDataAccess productDAO;

    @Mock
    private LanguageService languageService;

    @Mock
    private TranslationService translationService;

    @Before
    public void setUp() {
        productsService = new ProductsService(productDAO, languageService, translationService);
    }

    @Test
    public void priceWithPromotion() {
        double price = 47.5;
        int promotionPercentage = 15;

        Assert.assertEquals(40.375, productsService.priceWithPromotion(price, promotionPercentage), 0.01);
    }
}