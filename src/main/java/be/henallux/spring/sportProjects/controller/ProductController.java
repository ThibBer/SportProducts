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
@SessionAttributes(types = ShoppingCart.class)
public class ProductController extends MainController{
    private final MessageSource messageSource;
    private ProductsService productsService;
    private CategoriesService categoriesService;

    @Autowired
    public ProductController(MessageSource messageSource, ProductsService productsService, CategoriesService categoriesService) {
        this.messageSource = messageSource;
        this.productsService = productsService;
        this.categoriesService = categoriesService;
    }

    @RequestMapping(value = "/{id}/", method = RequestMethod.GET)
    public String getWithProductId(@PathVariable("id") String id, Model model, Locale locale) {
        model.addAttribute("locale", locale);
        try {
            int idProduct = Integer.parseInt(id);
            Product product = productsService.getProductWithId(idProduct, locale.getLanguage());
            if(product == null){
                return "integrated:notfound";
            }

            Category category = categoriesService.getCategoryWithId(product.getCategory().getId());

            model.addAttribute("category", category);
            model.addAttribute("product", product);
            model.addAttribute("shoppingCartItem", new ShoppingCartItem());
            return "integrated:product";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "integrated:error";
        }
    }

    @RequestMapping(value="/send", method = RequestMethod.POST)
    public String getFormData(Model model,
                              Locale locale,
                              @ModelAttribute ShoppingCartItem shoppingCartItem,
                              @SessionAttribute(value=SHOPPING_CART) ShoppingCart shoppingCart) {
        Integer quantity = shoppingCartItem.getQuantity();

        try {
            int idProduct = shoppingCartItem.getProductId();

            Product product = productsService.getProductWithId(idProduct, locale.getLanguage());
            if(product == null){
                return "integrated:notfound";
            }

            shoppingCart.addProductWithQuantity(idProduct, quantity);

            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "integrated:error";
        }
    }
}
