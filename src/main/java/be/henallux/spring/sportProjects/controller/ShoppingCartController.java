package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.Product;
import be.henallux.spring.sportProjects.model.ShoppingCart;
import be.henallux.spring.sportProjects.model.ShoppingCartItem;
import be.henallux.spring.sportProjects.service.ProductsService;
import be.henallux.spring.sportProjects.service.ShoppingCartService;
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
    private ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ProductsService productsService, ShoppingCartService shoppingCartService) {
        this.productsService = productsService;
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale, @ModelAttribute(value=SHOPPING_CART) ShoppingCart shoppingCart) {
        if(shoppingCart == null) {
            return "redirect:/";
        } else {
            HashMap<Integer, Integer> shoppingCartMap = shoppingCart.getProductsWithQuantities();
            HashMap<Product, Integer> shoppingCartItems = new HashMap<>();

            int articlesInPromotion = 0;

            for(Map.Entry<Integer, Integer> entry : shoppingCartMap.entrySet()) {
                Integer productId = entry.getKey();
                Integer quantity = entry.getValue();

                Product product = productsService.getProductWithId(productId, locale.getLanguage());

                if(product.getCategory().isInPromotion()){
                    articlesInPromotion++;
                }

                shoppingCartItems.put(product, quantity);
            }

            model.addAttribute("locale", locale);
            model.addAttribute("shoppingCartItems", shoppingCartItems);
            model.addAttribute("articlesInPromotion", articlesInPromotion);
            model.addAttribute("total", shoppingCartService.getTotalPrice(shoppingCartItems));
            model.addAttribute("articlesCount", shoppingCartItems.size());

            return "integrated:shopping-cart";
        }
    }
}
