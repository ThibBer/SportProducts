package be.henallux.spring.sportProjects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value = "/Bergnard")
public class CompanyController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCompanyPage(Model model, Locale locale) {
        model.addAttribute("locale", locale);
        return "integrated:company";
    }
}
