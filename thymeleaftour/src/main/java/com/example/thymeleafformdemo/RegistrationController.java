package com.example.thymeleafformdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// sourced from from:
//
// https://attacomsian.com/blog/spring-boot-thymeleaf-form-handling
//

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String createRegistrationForm(Model model) {

        model.addAttribute("myregistration", new RegistrationPOJO());
        return "register";
    }

    @PostMapping("/registration-details")
    public String saveRegistrationSubmission(Model model, RegistrationPOJO myregistration) {

        // TODO: save project in DB here
    	model.addAttribute("myregistration", myregistration);
        return "reg-det";
    }
}
