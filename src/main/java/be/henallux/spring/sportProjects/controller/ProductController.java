package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.*;
import be.henallux.spring.sportProjects.service.CategoriesService;
import be.henallux.spring.sportProjects.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.util.Locale;

@Controller
@RequestMapping(value="/product")
@SessionAttributes({MainController.SHOPPING_CART})
public class ProductController extends MainController{
    private ProductsService productsService;

    @ModelAttribute("shoppingCartItem")
    public ShoppingCartItem newShoppingCartItem() {
        return new ShoppingCartItem();
    }

    @Autowired
    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
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

            Category category = product.getCategory();
            if(category.isInPromotion()){
                product.setPriceWithPromotion(productsService.priceWithPromotion(product.getPrice(), category.getPromotion().getPercentage()));
            }

            model.addAttribute("category", category);
            model.addAttribute("product", product);
            return "integrated:product";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "integrated:error";
        }
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String getFormData(Model model,
                              Locale locale,
                              @ModelAttribute(value=SHOPPING_CART) ShoppingCart shoppingCart,
                              @Valid @ModelAttribute("shoppingCartItem") ShoppingCartItem shoppingCartItem,
                              final BindingResult errors,
                              final RedirectAttributes redirectAttributes) {
        model.addAttribute("locale", locale);
        Integer quantity = shoppingCartItem.getQuantity();
        int idProduct = shoppingCartItem.getProductId();

        Product product = productsService.getProductWithId(idProduct, locale.getLanguage());
        if(product == null){
            return "integrated:notfound";
        }

        if(errors.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shoppingCartItem", errors);
            redirectAttributes.addFlashAttribute("shoppingCartItem", shoppingCartItem);
            return "redirect:/product/" + product.getId() + "/";
        }

        Category category = product.getCategory();

        if(category.isInPromotion()){
            product.setPriceWithPromotion(productsService.priceWithPromotion(product.getPrice(), category.getPromotion().getPercentage()));
        }

        shoppingCart.addProductWithQuantity(idProduct, quantity);

        return "redirect:/category/" + category.getId() + "/";
    }
}
