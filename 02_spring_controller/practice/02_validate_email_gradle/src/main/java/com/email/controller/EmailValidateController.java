package com.email.controller;

import com.email.service.ICheckEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailValidateController {
@Autowired
    private ICheckEmailService iCheckEmailService;

    @GetMapping("/email")
    public String email() {
        return "/inputEmail";
    }

    @GetMapping("/validate")
    public ModelAndView emailValidate(@RequestParam String email) {
        return new ModelAndView("/inputEmail", "response", iCheckEmailService.checkEmail(email));
    }
}
