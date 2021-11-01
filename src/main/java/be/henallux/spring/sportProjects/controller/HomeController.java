package be.henallux.spring.sportProjects.controller;

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

    @Autowired
    public HomeController(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model, Locale locale){
        model.addAttribute("locale", locale);

        return "integrated:home";
    }
}
