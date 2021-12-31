package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.Product;
import be.henallux.spring.sportProjects.model.ShoppingCart;
import be.henallux.spring.sportProjects.service.ProductsService;
import be.henallux.spring.sportProjects.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping(value = "/paypal")
public class PaypalController extends MainController {
    private ProductsService productsService;

    @Autowired
    public PaypalController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getWithCategoryId(Model model, Locale locale, @ModelAttribute(value=SHOPPING_CART) ShoppingCart shoppingCart) {
        model.addAttribute("locale", locale);

        HashMap<Integer, Integer> shoppingCartMap = shoppingCart.getProductsWithQuantities();

        if(shoppingCartMap.size() == 0){
            return "redirect:/shopping-cart";
        }

        HashMap<Product, Integer> shoppingCartItems = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : shoppingCartMap.entrySet()) {
            Integer productId = entry.getKey();
            Integer quantity = entry.getValue();

            Product product = productsService.getProductWithId(productId, locale.getLanguage());

            shoppingCartItems.put(product, quantity);
        }

        model.addAttribute("shoppingCartItems", shoppingCartItems);

        shoppingCart.clear();

        return "integrated:paypal";
    }
}
