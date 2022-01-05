package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value = "/categories")
public class CategoriesController extends MainController{
    private CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService){
        this.categoriesService = categoriesService;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String categories (Model model, Locale locale){
        model.addAttribute("locale", locale);
        model.addAttribute("categories", categoriesService.getCategories());

        return "integrated:categories";
    }
}
