package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/")
public class HomeController extends MainController {
    private final MessageSource messageSource;
    private CategoriesService categoriesService;

    @Autowired
    public HomeController(MessageSource messageSource, CategoriesService categoriesService){
        this.messageSource = messageSource;
        this.categoriesService = categoriesService;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model, Locale locale){
        model.addAttribute("locale", locale);
        model.addAttribute("categories", categoriesService.getCategories());

        return "integrated:home";
    }
}
