package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.*;
import be.henallux.spring.sportProjects.service.CategoriesService;
import be.henallux.spring.sportProjects.service.LanguageService;
import be.henallux.spring.sportProjects.service.ProductsService;
import be.henallux.spring.sportProjects.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@RequestMapping(value="/product")
@SessionAttributes({ProductController.SHOPPING_CART})
public class ProductController {
    private final MessageSource messageSource;
    private ProductsService productsService;
    private LanguageService languageService;
    private TranslationService translationService;
    private CategoriesService categoriesService;
    protected static final String SHOPPING_CART = "shoppingCart";

    @Autowired
    public ProductController(MessageSource messageSource, ProductsService productsService, LanguageService languageService, TranslationService translationService, CategoriesService categoriesService) {
        this.messageSource = messageSource;
        this.productsService = productsService;
        this.languageService = languageService;
        this.translationService = translationService;
        this.categoriesService = categoriesService;
    }

    @ModelAttribute(SHOPPING_CART)
    public ShoppingCart sessionShoppingCart() {
        return ShoppingCart.getInstance();
    }

    @RequestMapping(value = "/{id}/", method = RequestMethod.GET)
    public String getWithProductId(@PathVariable("id") String id, Model model, Locale locale) {
        model.addAttribute("locale", locale);
        try {
            int idProduct = Integer.parseInt(id);
            Product product = productsService.getProductWithId(idProduct);
            if(product == null){
                return "integrated:notfound";
            }

            String internationalCode = locale.getLanguage();
            Language language = languageService.getLanguageWithInternationalCode(internationalCode);
            Translation translation = translationService.getTranslationWithProductIdAndLanguageId(idProduct, language.getId());
            Category category = categoriesService.getCategoryWithId(product.getCategoryId());
            product.setTranslation(translation);

            model.addAttribute("category", category);
            model.addAttribute("product", product);
            return "integrated:product";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "integrated:error";
        }
    }

    @RequestMapping(value="/{id}/send", method = RequestMethod.POST)
    public String getFormData(Model model,
                              Locale locale,
                              @PathVariable("id") String id,
                              @ModelAttribute(value=SHOPPING_CART) ShoppingCart shoppingCart) {
        try {
            int idProduct = Integer.parseInt(id);
            Product product = productsService.getProductWithId(idProduct);
            if(product == null)
                return "integrated:notfound";
            shoppingCart.addProductWithQuantity(product, 1);
            System.out.println(shoppingCart.toString());
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "integrated:error";
        }
    }

}
