package be.henallux.spring.sportProjects.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(value="/payments")
public class PaymentController {

    @RequestMapping(value="/paymentsuccess", method = RequestMethod.GET)
    public String getSuccessPage(Model model, Locale locale) {
        model.addAttribute("locale", locale);
        return "integrated:success";
    }

    @RequestMapping(value="/paymentcancelled", method = RequestMethod.GET)
    public String getCancelPage(Model model, Locale locale) {
        model.addAttribute("locale", locale);
        return "integrated:cancel";
    }
}
