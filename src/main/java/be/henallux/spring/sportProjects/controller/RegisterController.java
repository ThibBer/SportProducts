package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.UserForm;
import be.henallux.spring.sportProjects.service.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

@Controller
@RequestMapping(value="/register")
public class RegisterController {
    private final MessageSource messageSource;
    private UserDetailsServiceImplementation userService;

    @Autowired
    public RegisterController(MessageSource messageSource, UserDetailsServiceImplementation userService) {
        this.messageSource = messageSource;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model, Locale locale) {
        model.addAttribute("locale", locale);
        model.addAttribute("userForm", new UserForm());

        return "integrated:register";
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String getFormData(Model model,
                              Locale locale,
                              @Valid @ModelAttribute("userForm") UserForm inscriptionForm,
                              final BindingResult errors) {
        if(!errors.hasErrors()){

            return "redirect:/";
        }

        model.addAttribute("locale", locale);
        return "integrated:register";
    }
}
