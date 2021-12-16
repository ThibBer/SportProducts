package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.Language;
import be.henallux.spring.sportProjects.model.Product;
import be.henallux.spring.sportProjects.model.Translation;
import be.henallux.spring.sportProjects.service.LanguageService;
import be.henallux.spring.sportProjects.service.ProductsService;
import be.henallux.spring.sportProjects.service.TranslationService;
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
    private LanguageService languageService;
    private TranslationService translationService;

    @Autowired
    public ProductController(MessageSource messageSource, ProductsService productsService, LanguageService languageService, TranslationService translationService) {
        this.messageSource = messageSource;
        this.productsService = productsService;
        this.languageService = languageService;
        this.translationService = translationService;
    }

    @RequestMapping(value = "/{id}/", method = RequestMethod.GET)
    public String getWithProductId(@PathVariable("id") String id, Model model, Locale locale) {
        model.addAttribute("locale", locale);
        try {
            int idProduct = Integer.parseInt(id);
            Product product = productsService.getProductWithId(idProduct);
            if(product == null)
                return "integrated:notfound";
            String internationalCode = locale.getLanguage();
            Language language = languageService.getLanguageWithInternationalCode(internationalCode);
            Translation translation = translationService.getTranslationWithProductIdAndLanguageId(idProduct, language.getId());
            model.addAttribute("product", product);
            model.addAttribute("label", translation.getLabel());
            return "integrated:product";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "integrated:error";
        }
    }

}
