package com.register_form.controller;

import com.register_form.model.User;
import com.register_form.model.UserDto;
import com.register_form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @Autowired
    private IUserService userService;

    @GetMapping("/createForm")
    public String createForm(Model model) {
        model.addAttribute("userDto", new User());
        return "register";
    }

    @PostMapping("/saveInfo")
    public String userInfo(@ModelAttribute @Validated UserDto userDto, BindingResult bindingResult,
                             Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "register";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            model.addAttribute("userInfo", userService.registerUser(user));
            model.addAttribute("msgCreate", "Create successfully!");
            return "view";
        }

    }
}
