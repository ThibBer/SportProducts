package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.ProductDataAccess;
import be.henallux.spring.sportProjects.model.Language;
import be.henallux.spring.sportProjects.model.Product;
import be.henallux.spring.sportProjects.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

@Service
public class ProductsService {
    private ProductDataAccess productDataAccess;
    private LanguageService languageService;
    private TranslationService translationService;

    @Autowired
    public ProductsService(ProductDataAccess productDataAccess, LanguageService languageService, TranslationService translationService) {
        this.productDataAccess = productDataAccess;
        this.languageService = languageService;
        this.translationService = translationService;
    }

    public ArrayList<Product> getProductsWithCategoryId(int idCategory, String internationalCode) {
        ArrayList<Product> products = productDataAccess.getProductsWithCategoryId(idCategory);
        Language language = languageService.getLanguageWithInternationalCode(internationalCode);
        Translation translation;

        for(Product product : products){
            translation = translationService.getTranslationWithProductIdAndLanguageId(product.getId(), language.getId());
            product.setTranslation(translation);
        }

        return products;
    }

    public Product getProductWithId(int idProduct, String internationalCode) {
        Product product = productDataAccess.getProductWithId(idProduct);
        if(product != null) {
            Language language = languageService.getLanguageWithInternationalCode(internationalCode);
            Translation translation = translationService.getTranslationWithProductIdAndLanguageId(idProduct, language.getId());
            product.setTranslation(translation);
        }

        return product;
    }

    public Double priceWithPromotion(Double price, Integer promotionPercentage){
        if(promotionPercentage == 0){
            return price;
        }

        double priceWithPromotion = price * ( 1 - (promotionPercentage / 100.0));
        return (new BigDecimal(priceWithPromotion).setScale(2, RoundingMode.HALF_UP)).doubleValue();
    }

    public ArrayList<Product> getNumberRandomProducts(int numberProducts, String internationalCode) {
        ArrayList<Product> products = productDataAccess.getNumberRandomProducts(numberProducts);

        Language language = languageService.getLanguageWithInternationalCode(internationalCode);
        Translation translation;

        for(Product product : products){
            translation = translationService.getTranslationWithProductIdAndLanguageId(product.getId(), language.getId());
            product.setTranslation(translation);
        }

        return products;
    }
}
