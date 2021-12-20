package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.ShoppingCart;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

import static be.henallux.spring.sportProjects.controller.ProductController.SHOPPING_CART;

@Controller
@RequestMapping(value="/shopping-cart")
public class ShoppingCartController {

    @Autowired
    public ShoppingCartController() {}

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale, @SessionAttribute(value = SHOPPING_CART, required = false) ShoppingCart shoppingCart) {
        if(shoppingCart == null) {
            System.out.println("C NUL MON GARS");
            return "redirect:/";
        } else {
            model.addAttribute("locale", locale);
            model.addAttribute("shoppingCart", shoppingCart.getSessionShoppingCart());
            return "integrated:shopping-cart";
        }
    }
}
