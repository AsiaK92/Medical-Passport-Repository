package pl.sda.medicalpassport.infrastructure.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    ModelAndView loginPage(@RequestParam(required = false) String error){
        ModelAndView modelAndView = new ModelAndView("login_page.html");
        modelAndView.addObject("error", error);

        return modelAndView;
    }

}
