package be.henallux.spring.sportProjects.controller;

import be.henallux.spring.sportProjects.model.User;
import be.henallux.spring.sportProjects.model.UserForm;
import be.henallux.spring.sportProjects.service.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

@Controller
@RequestMapping(value="/register")
public class RegisterController extends MainController{
    private final MessageSource messageSource;
    private UserDetailsServiceImplementation userService;

    @Autowired
    public RegisterController(MessageSource messageSource, UserDetailsServiceImplementation userService) {
        this.messageSource = messageSource;
        this.userService = userService;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
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
        model.addAttribute("locale", locale);

        Boolean isEmailUsed = userService.isEmailAlreadyUsed(inscriptionForm.getEmail());
        if(isEmailUsed) {
            model.addAttribute("messageEmail", "already used");
        }

        Boolean isUsernameUsed = userService.isUsernameAlreadyUsed(inscriptionForm.getUsername());
        if(isUsernameUsed) {
            model.addAttribute("messageUsername", "already used");
        }

        if(errors.hasErrors() || isEmailUsed || isUsernameUsed)
            return "integrated:register";

        inscriptionForm.getBirthDate().setHours(12); //avoid losing a day in the process
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User(null, inscriptionForm.getEmail(), inscriptionForm.getFirstname(), inscriptionForm.getLastname(), inscriptionForm.getPhoneNumber(), inscriptionForm.getCity(), Integer.parseInt(inscriptionForm.getPostalCode()), inscriptionForm.getStreet(), inscriptionForm.getHouseNumber(), inscriptionForm.getBirthDate(), inscriptionForm.getUsername(), encoder.encode(inscriptionForm.getPassword()), "ROLE_USER", true, true, true, true);
        userService.postUser(user);
        return "redirect:/login";
    }
}
