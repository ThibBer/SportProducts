package be.henallux.spring.sportProjects.service;

import be.henallux.spring.sportProjects.dataAccess.dao.ProductDataAccess;
import be.henallux.spring.sportProjects.model.Language;
import be.henallux.spring.sportProjects.model.Product;
import be.henallux.spring.sportProjects.model.Translation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductsService {
    private ProductDataAccess productDAO;
    private LanguageService languageService;
    private TranslationService translationService;
    private ArrayList<Product> products;
    private Product product;

    @Autowired
    public ProductsService(ProductDataAccess productDAO, LanguageService languageService, TranslationService translationService) {
        this.productDAO = productDAO;
        this.languageService = languageService;
        this.translationService = translationService;
    }

    public ArrayList<Product> getProductsWithCategoryId(int idCategory, String internationalCode) {
        products = productDAO.getProductsWithCategoryId(idCategory);
        Language language = languageService.getLanguageWithInternationalCode(internationalCode);
        Translation translation;
        for(Product product : products){
            translation = translationService.getTranslationWithProductIdAndLanguageId(product.getId(), language.getId());
            product.setTranslation(translation);
        }

        return products;
    }

    public Product getProductWithId(int idProduct, String internationalCode) {
        product = productDAO.getProductWithId(idProduct);
        if(product != null) {
            Language language = languageService.getLanguageWithInternationalCode(internationalCode);
            Translation translation = translationService.getTranslationWithProductIdAndLanguageId(idProduct, language.getId());
            product.setTranslation(translation);
        }
        return product;
    }
}
