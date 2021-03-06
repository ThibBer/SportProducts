package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.*;
import be.henallux.spring.sportProjects.service.OrderProductService;
import be.henallux.spring.sportProjects.service.OrderService;
import be.henallux.spring.sportProjects.service.ProductsService;
import be.henallux.spring.sportProjects.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.*;

@Controller
@SessionAttributes({MainController.SHOPPING_CART})
@RequestMapping(value="/shopping-cart")
public class ShoppingCartController extends MainController {
    private ProductsService productsService;
    private ShoppingCartService shoppingCartService;
    private OrderService orderService;
    private OrderProductService orderProductService;

    @ModelAttribute("shoppingCartItem")
    public ShoppingCartItem newShoppingCartItem() {
        return new ShoppingCartItem();
    }

    @Autowired
    public ShoppingCartController(ProductsService productsService, ShoppingCartService shoppingCartService, OrderService orderService, OrderProductService orderProductService) {
        this.productsService = productsService;
        this.shoppingCartService = shoppingCartService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String shoppingCart(Model model, Locale locale, @ModelAttribute(value=SHOPPING_CART) ShoppingCart shoppingCart) {
        HashMap<Integer, Integer> shoppingCartMap = shoppingCart.getProductsWithQuantities();
        HashMap<Product, Integer> shoppingCartItems = new HashMap<>();

        int articlesInPromotion = 0;

        for(Map.Entry<Integer, Integer> entry : shoppingCartMap.entrySet()) {
            Integer productId = entry.getKey();
            Integer quantity = entry.getValue();

            Product product = productsService.getProductWithId(productId, locale.getLanguage());

            if(product.getCategory().isInPromotion()){
                articlesInPromotion++;

                product.setPriceWithPromotion(productsService.priceWithPromotion(product.getPrice(), product.getCategory().getPromotion().getPercentage()));
            }

            shoppingCartItems.put(product, quantity);
        }

        model.addAttribute("locale", locale);
        model.addAttribute("shoppingCartItems", shoppingCartItems);
        model.addAttribute("articlesInPromotion", articlesInPromotion);
        model.addAttribute("total", shoppingCartService.getTotalPrice(shoppingCartItems));
        model.addAttribute("shoppingCartItemsCount", shoppingCartItems.size());

        return "integrated:shopping-cart";
    }

    @RequestMapping(value="/editQuantity", method = RequestMethod.POST)
    public String editQuantity(@ModelAttribute(value=SHOPPING_CART) ShoppingCart shoppingCart,
                               @Valid @ModelAttribute("shoppingCartItem") ShoppingCartItem shoppingCartItem,
                               final BindingResult errors,
                               final RedirectAttributes redirectAttributes) {
        if(errors.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.shoppingCartItem", errors);
            redirectAttributes.addFlashAttribute("shoppingCartItem", shoppingCartItem);
            return "redirect:/shopping-cart";
        }

        shoppingCart.updateQuantity(shoppingCartItem.getProductId(), shoppingCartItem.getQuantity());

        return "redirect:/shopping-cart";
    }

    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute(value=SHOPPING_CART) ShoppingCart shoppingCart, @ModelAttribute ShoppingCartItem shoppingCartItem) {
        shoppingCart.removeProduct(shoppingCartItem.getProductId());

        return "redirect:/shopping-cart";
    }

    @RequestMapping(value = "/validation", method = RequestMethod.GET)
    public String shoppingCartValidation(Model model, Locale locale, @ModelAttribute(value=SHOPPING_CART) ShoppingCart shoppingCart) {
        HashMap<Integer, Integer> shoppingCartMap = shoppingCart.getProductsWithQuantities();

        if(shoppingCartMap.size() == 0){
            return "redirect:/shopping-cart";
        }

        HashMap<Product, Integer> shoppingCartItems = new HashMap<>();
        int articlesInPromotion = 0;

        for(Map.Entry<Integer, Integer> entry : shoppingCartMap.entrySet()) {
            Integer productId = entry.getKey();
            Integer quantity = entry.getValue();

            Product product = productsService.getProductWithId(productId, locale.getLanguage());

            if(product.getCategory().isInPromotion()){
                articlesInPromotion++;
                product.setPriceWithPromotion(productsService.priceWithPromotion(product.getPrice(), product.getCategory().getPromotion().getPercentage()));
            }

            shoppingCartItems.put(product, quantity);
        }

        model.addAttribute("locale", locale);
        model.addAttribute("shoppingCartItems", shoppingCartItems);
        model.addAttribute("articlesInPromotion", articlesInPromotion);
        model.addAttribute("total", shoppingCartService.getTotalPrice(shoppingCartItems));
        model.addAttribute("shoppingCartItemsCount", shoppingCartItems.size());
        model.addAttribute("shoppingCartItem", new ShoppingCartItem());

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        model.addAttribute("loggedUser", user);

        return "integrated:shopping-cartValidation";
    }

    @RequestMapping(value = "/payement", method = RequestMethod.POST)
    public String onPayement(Locale locale, @ModelAttribute(value=SHOPPING_CART) ShoppingCart shoppingCart) {
        HashMap<Integer, Integer> shoppingCartMap = shoppingCart.getProductsWithQuantities();

        if(shoppingCartMap.size() == 0){
            return "redirect:/shopping-cart";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        Date date = new Date();
        date.setHours(12);
        Order order = new Order(null, date, user);
        Order savedOrder = orderService.insertOrder(order);

        ArrayList<OrderProduct> orderProducts = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : shoppingCartMap.entrySet()) {
            Integer productId = entry.getKey();
            Integer quantity = entry.getValue();

            Product product = productsService.getProductWithId(productId, locale.getLanguage());
            if(product.getCategory().isInPromotion()){
                product.setPriceWithPromotion(productsService.priceWithPromotion(product.getPrice(), product.getCategory().getPromotion().getPercentage()));
            }

            orderProducts.add(new OrderProduct(null, quantity, product.getPriceWithPromotion(), savedOrder, product));
        }

        orderProductService.saveAll(orderProducts);

        return "redirect:/paypal";
    }
}
