package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/login")
public class LoginController extends MainController {
    @Autowired
    public LoginController(){}

    @RequestMapping (method = RequestMethod.GET)
    public String home (Model model, Locale locale){
        model.addAttribute("locale", locale);
        model.addAttribute("user", new User());

        return "integrated:login";
    }
}
