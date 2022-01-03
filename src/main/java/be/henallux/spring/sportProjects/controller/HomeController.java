package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.service.CategoriesService;
import be.henallux.spring.sportProjects.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/")
public class HomeController extends MainController {
    private final MessageSource messageSource;
    private CategoriesService categoriesService;
    private ProductsService productsService;
    private final static int NUMBER_CATEGORIES = 4;
    private final static int NUMBER_PRODUCTS = 4;

    @Autowired
    public HomeController(MessageSource messageSource, CategoriesService categoriesService, ProductsService productsService){
        this.messageSource = messageSource;
        this.categoriesService = categoriesService;
        this.productsService = productsService;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model, Locale locale){
        model.addAttribute("locale", locale);
        model.addAttribute("categories", categoriesService.getNumberRandomCategories(NUMBER_CATEGORIES));
        model.addAttribute("products", productsService.getNumberRandomProducts(NUMBER_PRODUCTS, locale.getLanguage()));

        return "integrated:home";
    }
}
