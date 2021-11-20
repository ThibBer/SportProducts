package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.dataAccess.dao.CategoryDAO;
import be.henallux.spring.sportProjects.dataAccess.dao.CategoryDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/")
public class HomeController {
    private final MessageSource messageSource;
    private CategoryDataAccess dao;

    @Autowired
    public HomeController(MessageSource messageSource, CategoryDAO dao){
        this.messageSource = messageSource;
        this.dao = dao;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model, Locale locale){
        model.addAttribute("locale", locale);
        model.addAttribute("categories", dao.getCategories());

        System.out.println(dao.getCategories());

        return "integrated:home";
    }
}
