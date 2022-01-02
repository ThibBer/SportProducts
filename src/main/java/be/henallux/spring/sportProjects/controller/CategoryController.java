package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.Category;
import be.henallux.spring.sportProjects.model.Language;
import be.henallux.spring.sportProjects.model.Product;
import be.henallux.spring.sportProjects.service.CategoriesService;
import be.henallux.spring.sportProjects.service.LanguageService;
import be.henallux.spring.sportProjects.service.ProductsService;
import be.henallux.spring.sportProjects.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;

@Controller
@RequestMapping(value = "/category")
public class CategoryController extends MainController {
    private final MessageSource messageSource;
    private CategoriesService categoriesService;
    private ProductsService productsService;

    @Autowired
    public CategoryController(MessageSource messageSource, CategoriesService categoriesService, ProductsService productsService) {
        this.messageSource = messageSource;
        this.categoriesService = categoriesService;
        this.productsService = productsService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String getWithCategoryId(@PathVariable("id") String id, Model model, Locale locale) {
        model.addAttribute("locale", locale);
        try {
            int idInteger = Integer.parseInt(id);
            Category category = categoriesService.getCategoryWithId(idInteger);
            if (category == null) {
                return "integrated:notfound";
            }

            ArrayList<Product> products = productsService.getProductsWithCategoryId(idInteger, locale.getLanguage());

            for(Product product: products){
                if(product.getCategory().isInPromotion()){
                    product.setPriceWithPromotion(productsService.priceWithPromotion(product.getPrice(), product.getCategory().getPromotion().getPercentage()));
                }
            }

            model.addAttribute("category", category);
            model.addAttribute("products", products);
            return "integrated:category";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
            return "integrated:error";
        }
    }
}
