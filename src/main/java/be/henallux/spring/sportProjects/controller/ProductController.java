package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.Product;
import be.henallux.spring.sportProjects.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/product")
public class ProductController {
    private final MessageSource messageSource;
    private ProductsService productsService;

    @Autowired
    public ProductController(MessageSource messageSource, ProductsService productsService) {
        this.messageSource = messageSource;
        this.productsService = productsService;
    }

    @RequestMapping(value = "/{id}/", method = RequestMethod.GET)
    public String getWithProductId(@PathVariable("id") String id, Model model, Locale locale) {
        model.addAttribute("locale", locale);
        try {
            int idInteger = Integer.parseInt(id);
            Product product = productsService.getProductWithId(idInteger);
            if(product == null)
                return "integrated:notfound";
            model.addAttribute("product", product);
            return "integrated:product";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "integrated:error";
        }
    }

}
