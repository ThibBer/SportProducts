package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.Product;
import be.henallux.spring.sportProjects.model.ShoppingCart;
import be.henallux.spring.sportProjects.model.ShoppingCartItem;
import be.henallux.spring.sportProjects.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@SessionAttributes({MainController.SHOPPING_CART})
@RequestMapping(value="/shopping-cart")
public class ShoppingCartController extends MainController {
    private ProductsService productsService;

    @Autowired
    public ShoppingCartController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale, @ModelAttribute(value=SHOPPING_CART) ShoppingCart shoppingCart) {
        if(shoppingCart == null) {
            return "redirect:/";
        } else {
            HashMap<Integer, Integer> shoppingCartMap = shoppingCart.getProductsWithQuantities();
            HashMap<Product, Integer> shoppingCartItems = new HashMap<>();

            for(Map.Entry<Integer, Integer> entry : shoppingCartMap.entrySet()) {
                Integer productId = entry.getKey();
                Integer quantity = entry.getValue();

                shoppingCartItems.put(productsService.getProductWithId(productId, locale.getLanguage()), quantity);
            }

            model.addAttribute("locale", locale);
            model.addAttribute("shoppingCartItems", shoppingCartItems);

            return "integrated:shopping-cart";
        }
    }
}
