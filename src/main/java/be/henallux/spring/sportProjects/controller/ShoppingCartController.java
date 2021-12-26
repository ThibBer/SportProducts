package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
@SessionAttributes(types = ShoppingCart.class)
public class ShoppingCartController extends MainController {

    @Autowired
    public ShoppingCartController() {}

    @RequestMapping(value = "/shopping-cart", method = RequestMethod.GET)
    public String home(Model model, Locale locale, @SessionAttribute(value=SHOPPING_CART) ShoppingCart shoppingCart) {
        if(shoppingCart == null) {
            return "redirect:/";
        } else {
            model.addAttribute("locale", locale);
            model.addAttribute("shoppingCart", shoppingCart.getProductsWithQuantities());
            return "integrated:shopping-cart";
        }
    }
}
