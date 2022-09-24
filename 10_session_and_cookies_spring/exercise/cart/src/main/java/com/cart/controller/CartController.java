package com.cart.controller;

import com.cart.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/cart")
public class CartController {
    /* required = false: dont need a value*/
    @GetMapping
    public ModelAndView cartList(@SessionAttribute(name = "cart", required = false) CartDto cart,
                                 HttpServletResponse response) {
//        Cookie cookie = new Cookie("productCart", cart + "");
//        cookie.setMaxAge(24 * 60 * 60); // lifetime is 1 days
//        cookie.setPath("/"); // global cookie
//        response.addCookie(cookie);
        return new ModelAndView("cart/cartList", "cart", cart);
    }
}
