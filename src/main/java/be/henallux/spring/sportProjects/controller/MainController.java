package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.ShoppingCart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({MainController.SHOPPING_CART})
public class MainController {
    protected static final String SHOPPING_CART = "shoppingCart";
    private ShoppingCart shoppingCart;

    public MainController(){
        shoppingCart = new ShoppingCart();
    }

    @ModelAttribute(SHOPPING_CART)
    public ShoppingCart shoppingCart() {
        return shoppingCart;
    }
}